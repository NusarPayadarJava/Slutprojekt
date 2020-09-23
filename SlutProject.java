import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField; 
		
	public class SlutProject   { 
    	static  int numOfNotes;	
    	
		    public static void main(String[] args) { 

		    	JFrame frame = new JFrame("Piano Spelare!");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(600,300);frame.setLayout(null);frame.setVisible(true);
	            
		          JButton b1 = new JButton("10"); b1.setBounds(50,50,50,100);
		          b1.setBackground(Color.BLACK); 
		            JButton b2 = new JButton("20"); b2.setBounds(100,50,50,100); 
		            b2.setBackground(Color.WHITE);
		               JButton b3 = new JButton("40"); b3.setBounds(150,50,50,100);
		               b3.setBackground(Color.BLACK);
		                 JButton b4 = new JButton("60"); b4.setBounds(200,50,50,100);
		                 b4.setBackground(Color.WHITE);
		              JButton b5 = new JButton("85"); b5.setBounds(250,50,50,100);
		              b5.setBackground(Color.BLACK);
		           JButton b6 = new JButton("95"); b6.setBounds(300,50,50,100);
		           b6.setBackground(Color.WHITE);
            JButton bx = new JButton("random"); bx.setBounds(150,200,100,30);
            bx.setBackground(Color.ORANGE); 
		          
		            frame.add(b1);frame.add(b2);frame.add(b3);frame.add(b4);
		            frame.add(b5);frame.add(b6); frame.add(bx); 
		        JLabel text=new JLabel("* spela piano med vanliga svart/vitt"); 
		        text.setBounds(355,50, 300,50);  
		        frame.add(text); 
		        JLabel text2=new JLabel("* orange knappen är random knap"); 
		        text2.setBounds(355,70, 300,50);  
		        frame.add(text2); 
		            
		        //-------- b1
	           b1.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	   numOfNotes=Integer.parseInt(b1.getText());
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           //-------- b2
	           b2.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	   numOfNotes=Integer.parseInt(b2.getText());
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           //-------- b3
	           b3.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	   numOfNotes=Integer.parseInt(b3.getText());
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           //-------- b4
	           b4.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	   numOfNotes=Integer.parseInt(b4.getText());
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           //-------- b5
	           b5.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	   numOfNotes=Integer.parseInt(b5.getText());
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           //-------- b6
	           b6.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	   numOfNotes=Integer.parseInt(b6.getText());
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           //-------- random b
	           bx.addActionListener(new ActionListener(){ 
	        	public void actionPerformed(ActionEvent e) {
	        	int random = (int) (Math.random() * 25);  numOfNotes= random;
	        	    SlutProject player = new SlutProject(); 
	                player.playPiano(numOfNotes); }   }); 
	           
	           
}//main
		    public void playPiano(int nr) {
		        try {
		        	
		            Sequencer sequencer = MidiSystem.getSequencer();
		            sequencer.open();
		            Sequence sequence = new Sequence(Sequence.PPQ,4);
		            Track track = sequence.createTrack();

		            ShortMessage a = new ShortMessage();
		            a.setMessage(144,1,nr,100);
		            MidiEvent noteOn = new MidiEvent(a, 1);
		            track.add(noteOn);

		            ShortMessage b = new ShortMessage();
		            b.setMessage(128,1,nr,100);
		            MidiEvent noteOff = new MidiEvent(b, 16);
		            track.add(noteOff);

		            sequencer.setSequence(sequence);
		            sequencer.start();
		        } catch (Exception ex) { ex.printStackTrace(); }

		    }
        		        
		  
}//class
		        