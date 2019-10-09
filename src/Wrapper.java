import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Wrapper {
	static int primary = 0;
	static int secondary = 0;
	static int tertiary = 0;
	static int id = 1;
	static String jstring = "Blank";
	static String currentdir = System.getProperty("user.dir");
	static JButton b1 = new JButton("Start Minecraft");
	static JButton b2 = new JButton("Open Minecraft Folder");
	static JButton b3 = new JButton("More Options");
	static JButton b4 = new JButton("Change Name");
	static JButton b5 = new JButton("Change your player ID");
	static JButton b6 = new JButton("Start a server");
	static JButton b7 = new JButton("Help (Opens browser)");
	static ButtonGroup bg = new ButtonGroup();
	static ButtonGroup bg1 = new ButtonGroup();
	static JRadioButton rb1 = new JRadioButton("Normal");
	static JRadioButton rb2 = new JRadioButton("Orange");
	static JRadioButton rb3 = new JRadioButton("Green");
	static JRadioButton rb4 = new JRadioButton("Red");
	static JRadioButton rb5 = new JRadioButton("Primary");
	static JRadioButton rb6 = new JRadioButton("Secondary");
	static JRadioButton rb7 = new JRadioButton("Tertiary");
	static JTextField tf1 = new JTextField();
	static JTextField tf2 = new JTextField();
	static JFrame frame = new JFrame();
	static JFrame frame2 = new JFrame();
	static JPanel p1 = new JPanel();
	static JPanel p2 = new JPanel();
	static JPanel p3 = new JPanel();
	static JPanel p4 = new JPanel();
	static JPanel p5 = new JPanel();
	static JLabel l1 = new JLabel();
	static JLabel l2 = new JLabel("Your ID is currently "+id+".");
	static GridLayout design = new GridLayout(3, 0);
	static GridLayout design2 = new GridLayout(1, 3);
	static GridLayout design3 = new GridLayout(4, 0);
	static Border border1 = BorderFactory.createLineBorder(Color.red);
	static Font font1 = new Font("SansSerif", Font.BOLD, 30);

	static void creategui() {
		frame.setTitle("Minecraft Launcher");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(design2);

		frame2.setTitle("Options");
		frame2.setVisible(false);
		frame2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame2.setSize(400, 200);
		frame2.setLocationRelativeTo(null);
		frame2.setLayout(design2);
		frame2.setAlwaysOnTop(true);
		
		p1.setBorder(border1);
		p2.setBorder(border1);
		p3.setBorder(border1);
		p4.setBorder(border1);

		b1.setFont(font1);
		
		p1.setLayout(design);
		p2.setLayout(design);
		p3.setLayout(design);
		p4.setLayout(design);
		p5.setLayout(design3);

		b1.setBackground(Color.green);
		b2.setBackground(Color.orange);
		b3.setBackground(Color.orange);
		
		rb1.setForeground(Color.blue);
		rb2.setForeground(Color.orange);
		rb3.setForeground(Color.green);
		rb4.setForeground(Color.red);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		p2.add(tf1);
		p2.add(b4);
		p2.add(l1);
		
		p3.add(b5);
		p3.add(tf2);
		p3.add(l2);
		
		p4.add(b7);
		p4.add(b6);
		p4.add(p5);
		
		p5.add(rb1);
		p5.add(rb2);
		p5.add(rb3);
		p5.add(rb4);
		p5.add(rb5);
		p5.add(rb6);
		p5.add(rb7);
		
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		
		bg1.add(rb5);
		bg1.add(rb6);
		bg1.add(rb7);

		frame.add(p2, BorderLayout.EAST);
		frame.add(p1, BorderLayout.WEST);
		frame2.add(p3, BorderLayout.EAST);
		frame2.add(p4, BorderLayout.WEST);

	}

	static void actionlisteners() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					@SuppressWarnings("unused")
					Process process1 = Runtime.getRuntime().exec(
							currentdir+"\\resources\\MinecraftLaunch.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				File myfile = new File(currentdir+"\\JavaPortableLauncher\\Data\\AppData\\.minecraft\\versions\\");
				String path = myfile.getAbsolutePath();
				File dir = new File(path.substring(0,
						path.lastIndexOf(File.separator)));
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().open(dir);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame2.setVisible(true);
				frame.setEnabled(false);
			}
		});
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					 
					jstring = tf1.getText();
					if(jstring.equals("") || jstring.contains("~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/")){
						l1.setText("Please type a valid name.");
						jstring = "Blank";
					}
					else if(jstring.equals("Brandon")||jstring.equals("brandon")){
						l1.setText("You have the name of my creator!");
					}
					else if(jstring.equals("ALegendsTale")||jstring.equals("alegendstale")){
						l1.setText("That is the username of my creator!");
					}
					else{
						l1.setText("Your name was changed!");
					}
					String content = "{\n  \"profiles\": {\n    \""+jstring+"\": {\n      \"name\": \""+jstring+"\",\n      \"playerUUID\": \"7f33af3262664946aa309864785f6b8"+id+"\"\n    }\n  },\n  \"selectedProfile\": \""+jstring+"\",\n  \"clientToken\": \"917b7796-408a-4998-b9b5-23a16354b07f\",\n  \"authenticationDatabase\": {\n    \"7f33af3262664946aa309864785f6b8"+id+"\": {\n      \"username\": \"blank@gmail.com\",\n      \"accessToken\": \"91a2dd5d9b464c36ba7d273af864ceea\",\n      \"userid\": \"a3a2dff1f43346868ebe0a75821b1a85\",\n      \"uuid\": \"7f33af32-6266-4946-aa30-9864785f6b8"+id+"\",\n      \"displayName\": \""+jstring+"\"\n    }\n  }\n}";
					
					File file = new File(currentdir + "\\JavaPortableLauncher\\Data\\AppData\\.minecraft\\launcher_profiles.json");
					
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);
					bw.close();
		 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					 
					String idstr = tf2.getText();
					if(idstr.equals("")){
						idstr = "1";
					}
					id = Integer.parseInt(idstr);
					
					if(id < 1 || id > 9){
						l2.setText("Please type a valid id.");
					}
					else{
						l2.setText("Your ID is currently "+id+".");
					}
					String content = "{\n  \"profiles\": {\n    \""+jstring+"\": {\n      \"name\": \""+jstring+"\",\n      \"playerUUID\": \"7f33af3262664946aa309864785f6b8"+id+"\"\n    }\n  },\n  \"selectedProfile\": \""+jstring+"\",\n  \"clientToken\": \"917b7796-408a-4998-b9b5-23a16354b07f\",\n  \"authenticationDatabase\": {\n    \"7f33af3262664946aa309864785f6b8"+id+"\": {\n      \"username\": \"blank@gmail.com\",\n      \"accessToken\": \"91a2dd5d9b464c36ba7d273af864ceea\",\n      \"userid\": \"a3a2dff1f43346868ebe0a75821b1a85\",\n      \"uuid\": \"7f33af32-6266-4946-aa30-9864785f6b8"+id+"\",\n      \"displayName\": \""+jstring+"\"\n    }\n  }\n}";
					
					File file = new File(currentdir + "\\JavaPortableLauncher\\Data\\AppData\\.minecraft\\launcher_profiles.json");
					
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);
					bw.close();
		 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				File myfile = new File(currentdir+"\\minecraft");
				String path = myfile.getAbsolutePath();
				File dir = new File(path.substring(0,
						path.lastIndexOf(File.separator)));
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().open(dir);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Desktop dk=Desktop.getDesktop();
				 try {
					dk.open(new File(currentdir + "\\resources\\help.html"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frame2.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	frame.setAlwaysOnTop(true);
		    	frame.setAlwaysOnTop(false);
		    	frame.setEnabled(true);
		    }
		});
		rb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//normal orange green red
				if(primary == 1){
					b1.setBackground(null);
				}
				else if(secondary == 1){
					b2.setBackground(null);
					b3.setBackground(null);
				}
				else if(tertiary == 1){
					b4.setBackground(null);
					b5.setBackground(null);
					b6.setBackground(null);
					b7.setBackground(null);
				}
			}
		});
		rb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(primary == 1){
					b1.setBackground(Color.orange);
				}
				else if(secondary == 1){
					b2.setBackground(Color.orange);
					b3.setBackground(Color.orange);
				}
				else if(tertiary == 1){
					b4.setBackground(Color.orange);
					b5.setBackground(Color.orange);
					b6.setBackground(Color.orange);
					b7.setBackground(Color.orange);
				}
			}
		});
		rb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(primary == 1){
					b1.setBackground(Color.green);
				}
				else if(secondary == 1){
					b2.setBackground(Color.green);
					b3.setBackground(Color.green);
				}
				else if(tertiary == 1){
					b4.setBackground(Color.green);
					b5.setBackground(Color.green);
					b6.setBackground(Color.green);
					b7.setBackground(Color.green);
				}
			}
		});
		rb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(primary == 1){
					b1.setBackground(Color.red);
				}
				else if(secondary == 1){
					b2.setBackground(Color.red);
					b3.setBackground(Color.red);
				}
				else if(tertiary == 1){
					b4.setBackground(Color.red);
					b5.setBackground(Color.red);
					b6.setBackground(Color.red);
					b7.setBackground(Color.red);
				}
			}
		});
		rb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				primary = 1;
				secondary = 0;
				tertiary = 0;
			}
		});
		rb6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				primary = 0;
				secondary = 1;
				tertiary = 0;
			}
		});
		rb7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				primary = 0;
				secondary = 0;
				tertiary = 1;
			}
		});

	}

	public static void main(String[] args) {
		creategui();
		actionlisteners();
	}

}