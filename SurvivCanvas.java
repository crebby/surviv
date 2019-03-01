import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.imageio.ImageIO;
public class SurvivCanvas{
	Ball ball1;
		Ball ball2;
		JFrame frame;

		public SurvivCanvas(int x,int y){
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 600);
			ball1 = new Ball(x,y,Color.RED);
			frame.add(ball1);
			frame.setVisible(true);
			Color tan = new Color(255,222, 173);
			ball1.setColor(tan);


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
			    g.setColor(c);
			    g.fillOval(xPos,yPos, 50, 50);
			    Color background = new Color(129,170,77);
			  setBackground(background);//background


	    	}
	}
	public static void main(String[] args){
		SurvivCanvas survivCanvas = new SurvivCanvas(300,200);
				for (int i=1;i<100;i++){
					survivCanvas.moveBall(i,100);
					survivCanvas.delay(5);
					survivCanvas.repaint();
				}

	}
}

