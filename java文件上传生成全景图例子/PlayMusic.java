

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Servlet implementation class PlayMusic
 */
public class PlayMusic extends Applet implements ActionListener {
	public final String[] AUDIO = { "alarm","123"};
	private Choice choice;
	private AudioClip[] clips;
	private Button playClip;
	private Button loopClip;
	private Button stopClip;
	private Button stopAllClips;
	private boolean[] clipsPlaying;

	public void init() {
		setBackground(Color.BLACK);
		choice = new Choice();
		clips = new AudioClip[AUDIO.length];
		clipsPlaying = new boolean[AUDIO.length];
		for (int i = 0; i < AUDIO.length; i++) {
			choice.add(AUDIO[i]);
			clips[i] = getAudioClip(getCodeBase(), AUDIO[i] + ".au");
			System.out.println(getCodeBase());
			clipsPlaying[i] = false;
		}
		add(choice);
		playClip = new Button("播放");
		playClip.addActionListener(this);
		add(playClip);

		loopClip = new Button("循环");
		loopClip.addActionListener(this);
		add(loopClip);

		stopClip = new Button("停止");
		stopClip.addActionListener(this);
		add(stopClip);

		stopAllClips = new Button("全部停止");
		stopAllClips.addActionListener(this);
		add(stopAllClips);

		stopClip.setEnabled(false);
		stopAllClips.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		int clipIndex = choice.getSelectedIndex();
		AudioClip clip = clips[clipIndex];
		System.out.println(clip);
		if (e.getSource() == playClip) {
			clip.play();
			stopClip.setEnabled(true);
			stopAllClips.setEnabled(true);
			clipsPlaying[clipIndex] = true;
		} else if (e.getSource() == loopClip) {
			clip.loop();
			stopClip.setEnabled(true);
			stopAllClips.setEnabled(true);
			clipsPlaying[clipIndex] = true;
		} else if (e.getSource() == stopClip) {
			clip.stop();
			stopClip.setEnabled(false);
			stopAllClips.setEnabled(false);
			clipsPlaying[clipIndex] = false;
			for (int i = 0; i < AUDIO.length; i++) {
				if (clipsPlaying[i]) {
					stopClip.setEnabled(true);
					stopAllClips.setEnabled(true);
					break;
				}
			}
		} else if (e.getSource() == stopAllClips) {
			for (int i = 0; i < AUDIO.length; i++) {
				if (clipsPlaying[i]) {
					clips[i].stop();
					clipsPlaying[i] = false;
				}
			}
			stopClip.setEnabled(false);
			stopAllClips.setEnabled(false);
		}
	}
}
