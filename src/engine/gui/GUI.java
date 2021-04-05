package engine.gui;

import engine.game.MessageService;
import engine.sound.SoundRegistry;
import engine.game.Scenario;
import engine.modele.entity.Entity;
import engine.modele.entity.player.Player;
import engine.modele.objets.Medicament;
import engine.modele.entity.Monstre;
import engine.modele.objets.Nourriture;
import engine.modele.objets.Objet;
import engine.modele.batiment.Piece;
import engine.modele.objets.Tresor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;

import engine.modele.objets.Key;

public class GUI extends JFrame {

    public static final int MAIN_WIDTH = 690;
    public static final int MAIN_HEIGHT = 690;
    public static JFrame frame;
    private JPanel panel;

    private Player player = Scenario.player;
    private Tresor tresor = Scenario.tresor;
    private Objet[] objet = Scenario.objets;
    private Entity[] individuses = Scenario.entities;
    private Objet[] objects = player.getInventaire();
    int i = 0;
    private Piece p1 = Scenario.p1;
    private int force = player.getForce();
    private int vie = player.getVie();
    private Key cl1 = Scenario.cl1;
    private Key cl2 = Scenario.cl2;
    private Key cl3 = Scenario.cl3;
    private InfoJoueur infoJoueur;

    JLabel info, Vie, Force, obj, messages;
    String objets = "Objets : ";
    panneau pan = new panneau();
    JButton nord = pan.nord;
    JButton nord1 = pan.nord1;
    JButton sud = pan.sud;
    JButton sud1 = pan.sud1;
    JButton est = pan.est;
    JButton est1 = pan.est1;
    JButton ouest = pan.ouest;
    JButton ouest1 = pan.ouest1;
    JButton key1 = pan.key1;
    JButton key2 = pan.key2;
    JButton key3 = pan.key3;
    JButton food = pan.food;
    JButton med = pan.med;
    JButton cuisinier = pan.cuisinier;
    JButton medecin = pan.medecin;
    JButton monstre = pan.monstre;
    JButton tresorbutton = pan.tresor;
    JPanel panelgagne = new JPanel();
    JPanel panelperdu = new JPanel();
    JLabel perdu = new JLabel("Vous avez perdu !  :( ");
    JLabel gagne = new JLabel("Vous avez gagn� !  :) ");
    JButton replay = new JButton("Recommencer");
    JButton quitter = new JButton("Quitter");
    JPanel south = new JPanel();

    /**
     * Creates new form test
     */
    public GUI() {
        initComponents();
        frame = this;
        infoJoueur = new InfoJoueur();
        infoJoueur.setVisible(true);
        infoJoueur.setLocation(1050, 0);
        this.setLayout(null);

        nord.setOpaque(false);
        nord.setContentAreaFilled(false);
        nord.setBorderPainted(false);

        sud.setOpaque(false);
        sud.setContentAreaFilled(false);
        sud.setBorderPainted(false);

        ouest.setOpaque(false);
        ouest.setContentAreaFilled(false);
        ouest.setBorderPainted(false);

        est.setOpaque(false);
        est.setContentAreaFilled(false);
        est.setBorderPainted(false);

        nord1.setOpaque(false);
        nord1.setContentAreaFilled(false);
        nord1.setBorderPainted(false);

        sud1.setOpaque(false);
        sud1.setContentAreaFilled(false);
        sud1.setBorderPainted(false);

        ouest1.setOpaque(false);
        ouest1.setContentAreaFilled(false);
        ouest1.setBorderPainted(false);

        est1.setOpaque(false);
        est1.setContentAreaFilled(false);
        est1.setBorderPainted(false);

        key1.setOpaque(false);
        key1.setContentAreaFilled(false);
        key1.setBorderPainted(false);

        key2.setOpaque(false);
        key2.setContentAreaFilled(false);
        key2.setBorderPainted(false);

        key3.setOpaque(false);
        key3.setContentAreaFilled(false);
        key3.setBorderPainted(false);

        food.setOpaque(false);
        food.setContentAreaFilled(false);
        food.setBorderPainted(false);

        med.setOpaque(false);
        med.setContentAreaFilled(false);
        med.setBorderPainted(false);

        cuisinier.setOpaque(false);
        cuisinier.setContentAreaFilled(false);
        cuisinier.setBorderPainted(false);

        medecin.setOpaque(false);
        medecin.setContentAreaFilled(false);
        medecin.setBorderPainted(false);

        monstre.setOpaque(false);
        monstre.setContentAreaFilled(false);
        monstre.setBorderPainted(false);

        tresorbutton.setOpaque(false);
        tresorbutton.setContentAreaFilled(false);
        tresorbutton.setBorderPainted(false);

        nord.addActionListener(new Nord());
        sud.addActionListener(new Sud());
        ouest.addActionListener(new Ouest());
        est.addActionListener(new Est());

        nord1.addActionListener(new Nord());
        sud1.addActionListener(new Sud());
        ouest1.addActionListener(new Ouest());
        est1.addActionListener(new Est());

        key1.addActionListener(new Cle1());
        key2.addActionListener(new Cle2());
        key3.addActionListener(new Cle3());
        food.addActionListener(new Food());
        med.addActionListener(new Med());
        monstre.addActionListener(new monster());
        cuisinier.addActionListener(new Cuisine());
        medecin.addActionListener(new Medecine());
        replay.addActionListener(new rep());
        quitter.addActionListener(new quit());

        south.add(replay);
        south.add(quitter);

        panelgagne.setBackground(Color.white);
        panelgagne.setLayout(new BorderLayout());
        panelgagne.add(gagne, BorderLayout.CENTER);
        panelgagne.add(south, BorderLayout.SOUTH);
        gagne.setForeground(Color.black);
        gagne.setHorizontalAlignment(JLabel.CENTER);
        panelgagne.add(gagne, BorderLayout.CENTER);

        panelperdu.setBackground(Color.white);
        panelperdu.setLayout(new BorderLayout());
        panelperdu.add(perdu, BorderLayout.CENTER);
        panelperdu.add(south, BorderLayout.SOUTH);
        perdu.setForeground(Color.black);
        perdu.setHorizontalAlignment(JLabel.CENTER);
        panelperdu.add(perdu, BorderLayout.CENTER);

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


        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null)
                objets = objets + objects[i].toString() + "; ";
            else
                objets = objets + "[VIDE]; ";
        }


        obj = new JLabel(objets);

        messages = new JLabel("");
        messages.setForeground(Color.BLACK);
        messages.setBounds(5, 100, 400, 100);

        info = new JLabel("Informations du joueur ");
        info.setForeground(Color.BLACK);
        Force = new JLabel("Force : " + force);
        Force.setForeground(Color.BLACK);
        Vie = new JLabel("Point de vie : " + vie);
        Vie.setForeground(Color.BLACK);
        obj.setForeground(Color.BLACK);

        info.setBounds(135, 5, 300, 14);
        Force.setBounds(5, 10, 100, 100);
        Vie.setBounds(5, 40, 100, 100);
        obj.setBounds(5, 70, 400, 100);

        infoJoueur.add(info);
        infoJoueur.add(Force);
        infoJoueur.add(Vie);
        infoJoueur.add(obj);
        infoJoueur.add(messages);

        this.setContentPane(pan);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
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

    /**
     * @param o
     */
    public void removeObjet(Objet o) {
        for (int i = 0; i < objet.length; i++) {
            if (objet[i] == o) {
                objet[i] = null;
                break;
            }
        }
    }


    class Cuisine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            force = Player.START_FORCE;
            messages.setText("Le joueur s'est nourrit");
            refreshvie();
            refreshforce();
        }
    }

    class Medecine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vie = Player.START_FORCE;
            messages.setText("Le joueur s'est soign�");
            refreshvie();
            refreshforce();
        }
    }

    class Nord implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (player.getPosition().possedePieceVoisine('N') != null && player.peutOuvrir(player.getPosition().AuNord())) {
                player.move('N');
                SoundRegistry.OPEN_DOOR_SOUND.play();
                messages.setText("Le joueur s'est d�placer au nord");
                force--;
                refreshforce();
                refreshvie();
                perdu();
                gagne();
            } else if (player.getPosition().possedePieceVoisine('N') != null && !player.peutOuvrir(player.getPosition().AuNord())) {
                MessageService.message = "Vous n'avez pas la cl� !";
                messages.setText("Vous n'avez pas la cl� !");
            } else {
                player.setPosition(player.getPosition());
                MessageService.message = "Il n'y a pas de porte";
                messages.setText("Il n'y a pas de porte");
            }
        }
    }

    class Sud implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (player.getPosition().possedePieceVoisine('S') != null && player.peutOuvrir(player.getPosition().AuSud())) {
                player.move('S');
                SoundRegistry.OPEN_DOOR_SOUND.play();
                messages.setText("Le joueur s'est d�plac� au sud");
                force--;
                refreshforce();
                refreshvie();
                perdu();
                gagne();
            }

        }
    }

    class Ouest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (player.getPosition().possedePieceVoisine('O') != null && player.peutOuvrir(player.getPosition().AOuest())) {
                player.move('O');
                SoundRegistry.OPEN_DOOR_SOUND.play();
                messages.setText("Le joueur s'est d�plac� � l'ouest");
                force--;
                refreshforce();
                refreshvie();
                perdu();
                gagne();
            }

        }
    }

    class Est implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (player.getPosition().possedePieceVoisine('E') != null && player.peutOuvrir(player.getPosition().AEst())) {
                player.move('E');
                SoundRegistry.OPEN_DOOR_SOUND.play();
                messages.setText("Le joueur s'est d�plac� � l'est");
                force--;
                refreshforce();
                refreshvie();
                perdu();
                gagne();
            }

        }
    }

    class Cle1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            prendreCle(cl1);
            SoundRegistry.TAKE_SOUND.play();
            key1.setVisible(false);
            refreshinv();
            messages.setText("La cle 1 a bien prise");
        }
    }

    class Cle2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            prendreCle(cl2);
            SoundRegistry.TAKE_SOUND.play();
            key2.setVisible(false);
            refreshinv();
            messages.setText("La cle 2 a bien prise");
        }
    }

    class Cle3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            prendreCle(cl3);
            SoundRegistry.TAKE_SOUND.play();
            key3.setVisible(false);
            refreshinv();
            messages.setText("La cle 3 a bien prise");
        }
    }


    class Food implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < Scenario.objets.length; i++) {
                if (Scenario.objets[i] instanceof Nourriture && Scenario.objets[i].getPosition() == player.getPosition()) {
                    Nourriture n = (Nourriture) Scenario.objets[i];
                    player.manger(n);
                    force++;
                    SoundRegistry.EAT_SOUND.play();
                    messages.setText("Le joueur a mang�");

                    break;

                }

            }

            refreshforce();
        }
    }

    class Med implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < Scenario.objets.length; i++) {
                if (Scenario.objets[i] instanceof Medicament && Scenario.objets[i].getPosition() == player.getPosition()) {
                    Medicament m = (Medicament) Scenario.objets[i];
                    player.soigner(m);
                    SoundRegistry.HEALTH_SOUND.play();
                    messages.setText("Le joueur a pris un medicament");
                    break;
                }
            }
            refreshvie();
        }
    }

    class rep implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GUI.main(null);
        }
    }

    class quit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class monster implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Monstre m = new Monstre(player.getPosition());
            for (int i = 0; i < individuses.length; i++) {
                if (individuses[i] instanceof Monstre && individuses[i].getPosition() == player.getPosition()) {
                    m = (Monstre) individuses[i];
                    break;
                }
            }
            messages.setText("Le combat a commenc� ");
            player.combat(m);
            vie -= 2;

        }
    }

    private boolean gagne() {
        if (player.getPosition() == tresor.getPosition()) {
            MessageService.message = "Vous avez gagn� :) !";
            messages.setText("Vous avez gagn� :) !");
            pan.setVisible(false);
            this.setContentPane(panelgagne);
            SoundRegistry.WIN_SOUND.play();
            SoundRegistry.BACKGROUND_SOUND.stop();
            return true;
        } else {
            return false;
        }
    }


    private void prendreCle(Key c) {
        if (i < 4) {
            objects[i] = c;
            i++;
        }
    }

    private boolean perdu() {
        if (force == 0 || vie == 0) {
            MessageService.message = "Vous avez perdu :( !";
            pan.setVisible(false);
            this.setContentPane(panelperdu);
            SoundRegistry.FAIL_SOUND.play();
            SoundRegistry.BACKGROUND_SOUND.stop();
            return true;
        } else return false;
    }

    /**
     *
     */
    public void refreshforce() {
        Force.setText("Force : " + force);
    }

    /**
     *
     */
    public void refreshvie() {
        Vie.setText("Vie : " + vie);
    }

    /**
     *
     */
    public void refreshinv() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) objets = objets + objects[i].toString() + "; ";
            else objets = objets + "[VIDE] ";
        }
    }

    public static void main(String[] args) {
        new Scenario();
        java.awt.EventQueue.invokeLater(() -> {
            SoundRegistry.BACKGROUND_SOUND.play();
            new GUI().setVisible(true);
        });
    }

}
