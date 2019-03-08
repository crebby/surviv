//user input assistance provided by https://examples.javacodegeeks.com/desktop-java/awt/event/simple-key-press-listener/
//look into https://www.quora.com/How-can-we-run-a-Java-program-into-an-HTML-coded-website for creating html selection screen(after working 1 v All)
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class SurvivCanvas{
		//class variables for the program
		public static int movex = 0;
		public static int movey = 0;
		public static int incriment = 4;
		public static int numOfNormBushes = 1;//(int)(Math.random()*89)+23;
		public static int numOfTrees = (int)(Math.random()*99)+30;
		public static int[][] nBushesp = new int[numOfNormBushes+1][numOfNormBushes+1];//(int)(Math.random()*100)+1;
		public static int i =0;

		Ball ball1;
		JFrame frame;

		public SurvivCanvas(int x,int y){
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 600);
			Color tan = new Color(255,222, 173);
			ball1 = new Ball(x,y,tan);
			frame.add(ball1);
			frame.setVisible(true);
			//stuff needed for user input
			JTextField textField = new JTextField();
			textField.addKeyListener(new MKeyListener());
			frame.add(textField);
			frame.setSize(600, 600);
			//spawn stuff
			for(int i=0;i<nBushesp.length;i++){

			}
		}

		public void moveBall(int x,int y){
			ball1.changePosition(x,y);
		}



		public void repaint(){
			frame.repaint();

		}

		public void changeBallColor(Color c){
			ball1.setColor(c);
		}

		public void delay(int x){
			try{
				Thread.sleep(x);
			}catch(Exception e){}
		}


		public class Ball extends JPanel{
			int xPos,yPos;
			Color c;
			public Ball(int x,int y,Color color){
				xPos=x;
				yPos=y;
				c=color;
			}

			public void changePosition(int x,int y){
				xPos=x;
				yPos=y;
			}

			public void setColor(Color color){
				c=color;
			}

			 public void paintComponent(Graphics g) {
			 	super.paintComponent(g);
			    //main guy
			    int s = 50;
			    g.setColor(c);
			    g.fillOval(xPos,yPos, s,s );
			    //each normal bush
			    g.setColor(new Color(0f,.5f,0f,.6665f ));
				g.fillOval(nBushesp[0][0],nBushesp[0][1],s+8,s+8);
				//trees

			    //crates

			    //weapons(may be divided into sub sections
			    //background stuff
			    Color background = new Color(129,170,77);
			  	setBackground(background);//background
	    	}
	}
	//this is for checking for user input and if the input is a command to move the person
		class MKeyListener extends KeyAdapter {

		   @Override
		    public void keyPressed(KeyEvent event) {
			char ch2 = event.getKeyChar();

			char ch = event.getKeyChar();
			if(ch2=='m'&&ch=='n')
				System.out.println("It can go diagnally");
			switch(ch){
				case 'w': System.out.println("Character moves up");
						  movey-=incriment;
						  break;
				case 'a': System.out.println("Character moves left");
						  movex-=incriment;
						  break;
				case 's': System.out.println("Character moves down");
						  movey+=incriment;
						  break;
				case 'd': System.out.println("Character moves right");
						  movex+=incriment;
			}

			 if (event.getKeyCode() == KeyEvent.VK_UP)
				movey-=incriment;
			if(event.getKeyCode()==KeyEvent.VK_DOWN)
				movey+=incriment;
			if(event.getKeyCode()==KeyEvent.VK_LEFT)
				movex-=incriment;
			if(event.getKeyCode()==KeyEvent.VK_RIGHT)
				movex+=incriment;

	    }
}
	public static void main(String[] args)throws Exception{

		SurvivCanvas survivCanvas = new SurvivCanvas(300,200);
		boolean inGame = true;
		while(inGame){
		survivCanvas.moveBall(movex,movey);
		survivCanvas.delay(5);
		survivCanvas.repaint();
		}
	}

}