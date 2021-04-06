package engine.gui;

import engine.game.Game;
import engine.modele.map.Orientation;
import engine.sound.SoundRegistry;
import engine.game.Scenario;
import engine.modele.entity.player.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;

import engine.modele.objets.Key;

public class GUI extends JFrame {

    public static final int MAIN_WIDTH = 690;
    public static final int MAIN_HEIGHT = 690;
    private final PlayerDataFrame playerDataFrame;
    private final Board board;
    private JPanel panel;

    JLabel info, healthLabel, forceLabel, inventoryLabel, actionLabel;
    JPanel winPanel = new JPanel();
    JPanel loosePanel = new JPanel();
    JLabel perdu = new JLabel("Vous avez perdu !  :( ");
    JLabel gagne = new JLabel("Vous avez gagné !  :) ");
    JButton replay = new JButton("Recommencer");
    JButton quitter = new JButton("Quitter");
    JPanel south = new JPanel();

    /**
     * Creates new form test
     */
    public GUI() {
        initComponents();
        playerDataFrame = new PlayerDataFrame();
        playerDataFrame.setVisible(true);
        playerDataFrame.setLocation(1050, 0);
        this.setLayout(null);
        board = new Board();

        Stream.of(Orientation.values()).forEach(orientation -> {
            board.getDoorButtons().get(orientation).addActionListener(event -> handleMove(orientation));
            board.getDoorLockedButtons().get(orientation).addActionListener(event -> handleMove(orientation));
        });

        IntStream.range(0, 3).forEach(id -> board.getKeyButtons().get(id).addActionListener(event -> handleKey(id)));

        board.getFoodButton().addActionListener(event -> {
            Scenario scenario = Game.getInstance().getScenario();
            scenario.getFoods().stream()
                    .filter(food -> food.getPosition().equals(scenario.getPlayer().getRoom()))
                    .findFirst()
                    .ifPresent(food -> {
                        scenario.getPlayer().manger(food);
                        SoundRegistry.EAT_SOUND.play();
                        actionLabel.setText("Le joueur a mangé");
                    });
            forceLabel.setText("Force : " + scenario.getPlayer().getForce());
        });
        board.getMonsterButton().addActionListener(e -> {
            Scenario scenario = Game.getInstance().getScenario();
            scenario.getPlayer().getMonsterNearby().ifPresent(monster -> {
                if(scenario.getPlayer().fight(monster)){
                    actionLabel.setText("Le joueur à gagné !");
                    //TODO monster set invisible
                }else{
                    actionLabel.setText("Le monstre à gagné ! ");
                    scenario.getPlayer().setVie(scenario.getPlayer().getVie()-monster.getForce());
                    healthLabel.setText("Vie : " + scenario.getPlayer().getVie());
                    checkLoose(scenario.getPlayer());
                }
            });
        });
        board.getDrugButton().addActionListener(e -> {
            Scenario scenario = Game.getInstance().getScenario();
            scenario.getDrugs().stream()
                    .filter(drug -> drug.getPosition().equals(scenario.getPlayer().getRoom()))
                    .findFirst()
                    .ifPresent(drug -> {
                        scenario.getPlayer().soigner(drug);
                        SoundRegistry.HEALTH_SOUND.play();
                        actionLabel.setText("Le joueur a pris un medicament");
                    });
            healthLabel.setText("Vie : " + scenario.getPlayer().getVie());
        });
        board.getCookerButton().addActionListener(e -> {
            Scenario scenario = Game.getInstance().getScenario();
            scenario.getPlayer().setForce(Player.START_FORCE);
            actionLabel.setText("Le joueur s'est nourrit");
            forceLabel.setText("Force : " + scenario.getPlayer().getForce());
            healthLabel.setText("Vie : " + scenario.getPlayer().getVie());
        });
        board.getDoctorButton().addActionListener(e -> {
            Scenario scenario = Game.getInstance().getScenario();
            scenario.getPlayer().setVie(Player.START_VIE);
            actionLabel.setText("Le joueur s'est soigné");
            forceLabel.setText("Force : " + scenario.getPlayer().getForce());
            healthLabel.setText("Vie : " + scenario.getPlayer().getVie());
        });
        replay.addActionListener(e -> Game.getInstance().start());
        quitter.addActionListener(e -> System.exit(0));

        south.add(replay);
        south.add(quitter);

        winPanel.setBackground(Color.white);
        winPanel.setLayout(new BorderLayout());
        winPanel.add(gagne, BorderLayout.CENTER);
        winPanel.add(south, BorderLayout.SOUTH);
        gagne.setForeground(Color.black);
        gagne.setHorizontalAlignment(JLabel.CENTER);
        winPanel.add(gagne, BorderLayout.CENTER);

        loosePanel.setBackground(Color.white);
        loosePanel.setLayout(new BorderLayout());
        loosePanel.add(perdu, BorderLayout.CENTER);
        loosePanel.add(south, BorderLayout.SOUTH);
        perdu.setForeground(Color.black);
        perdu.setHorizontalAlignment(JLabel.CENTER);
        loosePanel.add(perdu, BorderLayout.CENTER);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };


        this.setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 974, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 514, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        this.setSize(MAIN_WIDTH, MAIN_HEIGHT);

        panel.setFocusable(true);

        inventoryLabel = new JLabel(getInventoryString(Game.getInstance().getScenario().getPlayer()));

        actionLabel = new JLabel("");
        actionLabel.setForeground(Color.BLACK);
        actionLabel.setBounds(5, 100, 400, 100);

        info = new JLabel("Informations du joueur ");
        info.setForeground(Color.BLACK);
        forceLabel = new JLabel("Force : " + Game.getInstance().getScenario().getPlayer().getForce());
        forceLabel.setForeground(Color.BLACK);
        healthLabel = new JLabel("Point de vie : " + Game.getInstance().getScenario().getPlayer().getVie());
        healthLabel.setForeground(Color.BLACK);
        inventoryLabel.setForeground(Color.BLACK);

        info.setBounds(135, 5, 300, 14);
        forceLabel.setBounds(5, 10, 100, 100);
        healthLabel.setBounds(5, 40, 100, 100);
        inventoryLabel.setBounds(5, 70, 400, 100);

        playerDataFrame.add(info);
        playerDataFrame.add(forceLabel);
        playerDataFrame.add(healthLabel);
        playerDataFrame.add(inventoryLabel);
        playerDataFrame.add(actionLabel);

        this.setContentPane(board);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 525, Short.MAX_VALUE)
        );
        pack();
    }

    private void handleMove(Orientation orientation){
        Player player = Game.getInstance().getScenario().getPlayer();
        player.getRoom().getDoor(orientation).ifPresent(door -> {
            if (player.peutOuvrir(door)) {
                player.move(orientation);
                SoundRegistry.OPEN_DOOR_SOUND.play();
                actionLabel.setText("Le joueur s'est déplacé au "+orientation);
                player.setForce(Math.max(player.getForce() - 1, 0));
                forceLabel.setText("Force : " + player.getForce());
                healthLabel.setText("Vie : " + player.getVie());
                checkLoose(player);
                checkVictory(player);
            } else {
                actionLabel.setText("Vous n'avez pas la clé !");
            }
        });
    }

    private void handleKey(int id){
        final Scenario scenario = Game.getInstance().getScenario();
        Key key = scenario.getKeys().get(id);
        prendreCle(scenario.getPlayer(), key);
        board.getKeyButtons().get(id).setVisible(false);
        inventoryLabel.setText(getInventoryString(scenario.getPlayer()));
        actionLabel.setText("La clé "+(id+1)+" à bien été prise");
    }

    private void prendreCle(Player player, Key key) {
        int availableSlot = -1;
        for(int i = 0 ; i < 4 ; i++){
            if(player.getInventaire()[i] != null){
                availableSlot = i;
            }
        }
        if (availableSlot != -1) {
            player.getInventaire()[availableSlot] = key;
        }else{
            actionLabel.setText("Inventaire plein !");
        }
    }

    private void checkLoose(Player player) {
        if (player.getForce() > 0 && player.getVie() > 0) return;

        String reason;
        if (player.getForce() <= 0) {
            reason = "Vous n'avez plus de force !";
        } else {
            reason = "Vous n'avez plus de vie !";
        }
        actionLabel.setText(reason);
        this.setContentPane(loosePanel);
        SoundRegistry.FAIL_SOUND.play();
        SoundRegistry.BACKGROUND_SOUND.stop();
    }

    private void checkVictory(Player player) {
        if (!player.getRoom().equals(Game.getInstance().getScenario().getChest().getPosition())) return;

        actionLabel.setText("Vous avez gagné :) !");
        this.setContentPane(winPanel);
        SoundRegistry.WIN_SOUND.play();
        SoundRegistry.BACKGROUND_SOUND.stop();
    }


    private String getInventoryString(Player player) {
        String content = "Objets : ";
        for (int i = 0; i < player.getInventaire().length; i++) {
            if (player.getInventaire()[i] != null) content += player.getInventaire()[i].toString() + "; ";
            else content += "[VIDE] ";
        }
        return content;
    }

}
