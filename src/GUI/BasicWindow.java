import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Neki komentari tu i tamo

public class BasicWindow extends Frame {

	public BasicWindow() {
		Rectangle rect = new Rectangle(0,0,500,500);
		Canvas can = new Canvas();
		add(can);
		can.setBackground(Color.white);
		can.setBounds(rect);
		can.addMouseMotionListener(new MouseMotionAdapter() {

			private int size = 10;
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Graphics g = can.getGraphics();
				g.setColor(Color.red);
					
				Point p = e.getPoint();
				System.out.println(p.getLocation().toString());
				g.fillOval(p.x - size/2, p.y - size/2, size, size);
				repaint();
			}

			
		});
		setBounds(rect);
		setTitle("Neki naslov");
		setResizable(true);
		//populateWindow();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	public void Resize(int x, int y, int w, int h) {
		this.setBounds(x,y,w,h);
	}
	
	private void populateWindow() {
		
		Label west = new Label("West");
		Label south = new Label("South");
		Label east = new Label("East");
		Label north = new Label("North");
		Label center = new Label("Center");
		
		center.setAlignment(Label.CENTER);
		
		west.setBackground(Color.MAGENTA);
		south.setBackground(Color.GREEN);
		east.setBackground(Color.YELLOW);
		north.setBackground(Color.red);
		center.setBackground(Color.orange);
		
		this.add(north, BorderLayout.NORTH);
		this.add(west, BorderLayout.WEST);
		this.add(south, BorderLayout.SOUTH);
		this.add(center, BorderLayout.CENTER);
		this.add(east, BorderLayout.EAST);

	}
	public static void main(String[] args){
		new BasicWindow();
	};
}
