package fileUpload_Download_teacher_sample;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

/*
 *  table sql
 *  
 * create table tblimg(
 *     idx int auto_increment primary key,
 *     img MEDIUMBLOB
 * );
 *  
 * */

public class Base64 extends JFrame implements ActionListener{
	//private DBConnectionMgr pool;
	JPanel mainPnl;
	JPanel southPnl;
	JTextField tf;
	JButton btn;
	JButton btnGet;
	Image img;
	JLabel background;	
	JLabel notice;
	
	public Base64() {	
				
		//pool = DBConnectionMgr.getInstance();
		
		mainPnl = new JPanel();
		southPnl = new JPanel();
		tf = new JTextField(20);
		btn = new JButton("insert");
		btnGet = new JButton("select");
		notice = new JLabel("<html><body>C:\\Downloads\\aa.png ←이런식으로 입력후 insert<br> ex) 1 ← 불러올 때는 데이터베이스의 idx 값을 입력후 select </body></html>");
		
		this.add(notice,BorderLayout.NORTH);
		tf.setText("상단의 사용법 확인!!"); 
		
		btn.addActionListener(this);
		btnGet.addActionListener(this);
		
//		try {
//			img = ImageIO.read(new File("C:\\Java\\myJava\\member\\colrow.png"));
//			background = new JLabel(new ImageIcon(img));
//		} catch (IOException e) {
//			tf.setText("failed!");
//			e.printStackTrace();
//		}		
		
		//mainPnl.add(background);		

		this.add(mainPnl);
		
		southPnl.add(tf);
		southPnl.add(btn);
		southPnl.add(btnGet);
		
		this.add(southPnl,BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	
//public void writeImg(String imgName) {
//		
//		File file = new File(imgName);
//        FileInputStream input=null;
//		try {
//			input = new FileInputStream(file);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		String sql = null;
//		boolean flag = false;
//		try {
//			
//			con = pool.getConnection();
//			
//			sql = "insert into tblimg (img) values (?)";
//			
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setBinaryStream(1, input);			
//			
//			int cnt = pstmt.executeUpdate();
//			if(cnt==1) tf.setText("OK!");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			pool.freeConnection(con, pstmt);
//		}						
// 
//	}
//	
//	public void readImg(String idx) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;
//		
//		try {
//			con = pool.getConnection();
//			sql = "select img from tblimg where idx=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(idx));
//			rs = pstmt.executeQuery();
//			File file = new File("this.png");
//            FileOutputStream output = new FileOutputStream(file);            
//            
//            if (rs.next()) {
//                InputStream input = rs.getBinaryStream(1);
//                byte[] buffer = new byte[1024];
//                while (input.read(buffer) > 0) {
//                    output.write(buffer);
//                }
//                tf.setText(file.getAbsolutePath());
//                
//                try {
//        			img = ImageIO.read(new File(file.getAbsolutePath()));
//        			background.setIcon(new ImageIcon(img));
//        		} catch (IOException e) {
//        			tf.setText("failed!");
//        			e.printStackTrace();
//        		}		
//        		
//        		mainPnl.add(background);	
//            }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			pool.freeConnection(con, pstmt, rs);
//		}		
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
//			writeImg(tf.getText());
		}else {
//			readImg(tf.getText());
		}
	}

	public static void main(String[] args) {
		new Base64(); 
	}
}