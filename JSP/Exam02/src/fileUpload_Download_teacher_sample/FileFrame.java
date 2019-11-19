package fileUpload_Download_teacher_sample;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;


/* Database Table 
 * 
 *  create table fileTest(
        idx int auto_increment primary key,
        filename VARCHAR(255),
        realFile MEDIUMBLOB
	);
 */
public class FileFrame extends JFrame implements ActionListener {
	
		final static String dir="D:/"; // 저장위치
		
        JPanel nPan,mPan,sPan;
        JLabel pLbl;
        JTextField pTf;
        JButton cBtn;
        JButton sBtn;
        JButton open;
        JFileChooser f;
        JLabel imglbl;
        JPanel nPan1;
        JPanel nPan2;
        
        Connection conn;
        
        public FileFrame() {
                String jdbcUrl = "jdbc:mysql://localhost:3307/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
                String username = "root";
                String pw = "1111";

                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection(jdbcUrl, username, pw);
                } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                } catch (ClassNotFoundException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();

                }

                nPan = new JPanel(new BorderLayout());
                
                nPan1 = new JPanel();
                pLbl = new JLabel("파일위치 : ");
                pTf = new JTextField(30);
                open = new JButton("열기");
                open.addActionListener(this);
                f=new JFileChooser();
                
                nPan1.add(pLbl);
                nPan1.add(pTf);
                nPan1.add(open);
                nPan.add(nPan1,BorderLayout.NORTH);
                
                
                nPan2 = new JPanel();
                nPan2.add(new JLabel("<html>사용법 <br/> <font color='red'>\"열기\"</font> 버튼을 이용하여 파일을 선택후 <font color='red'>\"저장\"</font><br/> Database의 idx 번호 ex) 1 을 입력후 <font color='red'>\"불러오기\"</font></html>"));
                nPan.add(nPan2, BorderLayout.CENTER);

                sPan = new JPanel();
                mPan = new JPanel();
                imglbl = new JLabel();
                mPan.add(imglbl);
                
                cBtn = new JButton("저장");
                cBtn.addActionListener(this);
                

                
                sBtn = new JButton("불러오기");
                sBtn.addActionListener(this);
                
                sPan.add(cBtn);
                sPan.add(sBtn);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                this.add(nPan, BorderLayout.NORTH);
                this.add(mPan, BorderLayout.CENTER);
                this.add(sPan, BorderLayout.SOUTH);

                this.setSize(500, 600);
                this.setVisible(true);

        }
        
        int InsertData(){
                PreparedStatement pstmt= null;
                String sql = null;
                int result = 0;
                
                try {
                        File f = new File(pTf.getText());
                        FileInputStream fis = new FileInputStream(f);
                        sql = "insert into fileTest (fileName, realFile) values (?,?)";

                        String x1= pTf.getText().substring(pTf.getText().lastIndexOf("\\")+1); //파일명만 들고옴.
                        pstmt=conn.prepareStatement(sql);
                        pstmt.setString(1, x1);
                        
                        pstmt.setBinaryStream(2, fis);
                        result = pstmt.executeUpdate();
                        
                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return result;
        }
        
        void loadData(){
                PreparedStatement pstmt= null;
                String sql = null;
                ResultSet rs = null;
                
                try {
                        sql="select * from fileTest where idx=?";
                        pstmt=conn.prepareStatement(sql);
                        pstmt.setInt(1, Integer.parseInt(pTf.getText()));
                        rs=pstmt.executeQuery();
                        if(rs.next()){
                                File f=new File(dir+rs.getString(2));
                                FileOutputStream fos = new FileOutputStream(f);        
                                InputStream is=rs.getBinaryStream(3);
                                byte[] buffer = new byte[1024];
                                while(is.read(buffer)>0){
                                        fos.write(buffer);
                                }
                                ImageIcon img = new ImageIcon(dir+rs.getString(2));
                                imglbl.setIcon(img);
                                fos.close();
                        }
                        
                        

                } catch (Exception e) {
                        e.printStackTrace();
                }

                
        }
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cBtn){
                        if(InsertData()<0){
                                JOptionPane.showMessageDialog(null, "에러!!!");
                        }else{
                                JOptionPane.showMessageDialog(null, "저장되었습니다.");
                        }
                
                }else if(e.getSource()==sBtn){
                        loadData();
                        JOptionPane.showMessageDialog(null, "파일을 불러왔습니다.");
                                        
                }else if(e.getSource()==open){
                                int val = f.showOpenDialog(this);
                                if(val==JFileChooser.APPROVE_OPTION){
                                        //열기
//                                        System.out.println(f.getSelectedFile());
                                        pTf.setText(f.getSelectedFile().getPath());
                                }else{
                                        //취소
                                }
                        }
        }

        public static void main(String[] args) {
                new FileFrame();
        }

}