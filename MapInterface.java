//Main class for Bus Station Project
//Rakeem Sam and Adam
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.geom.Path2D;
import java.awt.event.*;
public class MapInterface extends JFrame {
	public MapInterface() {
		this.setLayout(new BorderLayout());
		//Issue 1: topPanel was not needed due to class Draw
		//JPanel topPanel = new JPanel(new FlowLayout());
		JPanel bottomPanel = new JPanel(new FlowLayout());
		
		//Bottom Panel Buttons to Access Other Classes ((BUS,ROUTE,STATION)
		JButton bus = new JButton("Bus");
		bottomPanel.add(bus);
		JButton route = new JButton("Route");
		bottomPanel.add(route);
		JButton station = new JButton("Station");
		bottomPanel.add(station);
	
		//Issue 2: bottomPanel.add(newJButton("xxxxxxx");
		
		//Coding JButtons to open different jframes
		bus.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent ae) {
				new BusFrame();
			}
				});
		
		route.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent ae) {
		new RouteFrame();
	}
		});
		
		station.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent ae) {
		new StationFrame();
	}
		});

		//Line of code to add draw class to JFrame
		add(new Draw());
		
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}
	
	class Draw extends JPanel{
		// Creates "frame" to house map interface. Can be adjusted to meet size requirements
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D gg = (Graphics2D) g;
			g.drawLine(15, 15, 385, 15);
			g.drawLine(15, 385, 385, 385);
			g.drawLine(15, 15, 15, 385);
			g.drawLine(385, 15, 385, 385);
			Path2D d = new Path2D.Double();
			d.moveTo(275, 0);
			gg.draw(d);
		}
	}
	
	public static void main(String[] args) {
		MapInterface frame = new MapInterface();
		frame.setTitle("Bus Station Interface");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,500);
		frame.setVisible(true);
	}

}
