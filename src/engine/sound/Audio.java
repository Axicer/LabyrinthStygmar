package engine.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {

	private AudioClip clip;

	public Audio(String filename){
		try{
			clip = Applet.newAudioClip(Audio.class.getResource(filename));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play(){
		try{
			new Thread(() -> clip.play()).start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stop(){
		try{
			new Thread(() -> clip.stop()).start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
