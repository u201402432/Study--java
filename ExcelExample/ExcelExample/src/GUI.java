
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
public class GUI 
{

	// 인스턴스 변수로 사용하기 위해 start메서드ㅐ0 밖으로 꺼냈습니다. 왜냐면 이벤트 발생시 이벤트 메서드에서 사용되기 때문입니다.
	private JTextField tf1 = new JTextField(40); // 텍스트 필드 생성
	private JTextField tf2 = new JTextField(40); 
	private JTextField tf3 = new JTextField(40);

	private JButton b1 = new JButton("파일추가");	// 파일추가 버튼입니다.
	private JButton b2 = new JButton("파일추가");
	private JButton b3 = new JButton("파일추가");
	private JButton br = new JButton("그룹스케줄러 실행"); 

	private static ExcelReader _excelreader ;
	private static XSSFworkbook _xwb ;
	private static JFileChooser fc ;

	public static void main(String args[])
	{
		fc = new JFileChooser();
		_xwb = new XSSFworkbook() ;

		GUI g = new GUI();	//
		g.start();
	}
	//////////////////////////////////////
	public void start()
	{
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panelr = new JPanel();
		JPanel panelVer = new JPanel();

		JLabel l1 = new JLabel("파일경로");	// 텍스트필드앞에 설명해주기 위해 레이블을 추가하였습니다.
		JLabel l2 = new JLabel("파일경로");
		JLabel l3 = new JLabel("파일경로");

		//setLayout으로 각 버튼은 수평으로 배치 하도록 설정합니다.

		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 4 , 4));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 4 , 4));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 4 , 4));
		panelr.setLayout(new FlowLayout(FlowLayout.CENTER,4, 4));
		// 수평으로 나열된 패널들을 서로 수직으로 배열 할 수있도록 도와주니다.
		panelVer.setLayout(new BoxLayout(panelVer,BoxLayout.Y_AXIS));
		//각 panel1,2,3 에는 버튼과 텍스트 필드를 배치
		panel1.add(l1); //첫번째 줄의 컴포넌트
		panel1.add(tf1);
		panel1.add(b1);

		panel2.add(l2);//두번째 줄의 컴포넌트
		panel2.add(tf2);
		panel2.add(b2);

		panel3.add(l3);//세번째 줄의 컴포넌트
		panel3.add(tf3);
		panel3.add(b3);

		panelr.add(br);//출력버튼에 대한 컴포넌트

		panelVer.add(panel1);//각 줄을 수직으로 놓기 위한 패널
		panelVer.add(panel2);
		panelVer.add(panel3);

		frame.getContentPane().add(BorderLayout.CENTER,panelVer);
		frame.getContentPane().add(BorderLayout.SOUTH,panelr);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(630, 200);
		frame.setVisible(true);

		//button event를 읽어줄 Lister
		b1.addActionListener(new fileButtonListener());
		b2.addActionListener(new fileButtonListener());
		b3.addActionListener(new fileButtonListener());
		br.addActionListener(new fileButtonListener());
	}

	//////////////////////////////////
	//내부 클래스 형태로 두개의 이벤트를 구현하겠습니다.
	//하나는 파일추가 버튼들에 대한 이벤트
	//하나는 결과출력에 관한 이벤트 이지만 내부클래스만 생성해놓고 생략하겠습니다.
	class fileButtonListener implements ActionListener
	{

		// 파일추가 버튼에 관한 이벤트 들입니다.
		// ActionEvent 클래스의 getSource() 메서드를 사용하여
		// 해당 이벤트가 발생한 객체의 Reference 변수의 주소와 일치한다면 해당 버튼이 있는 Panel의 textfield에다 String을 set합니다.
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//여기에 저장된  String을
			String s = "파일을 추가하세요.";

			if(e.getSource() == b1){
				tf1.setText(s) ;
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{

					File file = fc.getSelectedFile();

					// 엑셀 파일을 문자열로 읽어온다.
					_excelreader = new ExcelReader(file, _xwb) ;
					try {
						_excelreader.read();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					tf1.setText(file.getPath());
				}

			}
			else if(e.getSource() == b2){
				//여기에 저장된  String을
				tf2.setText(s) ;

				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();

					// 엑셀 파일을 문자열로 읽어온다.
					_excelreader = new ExcelReader(file, _xwb) ;
					try {
						_excelreader.read();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					tf2.setText(file.getPath());
				}
			}
			else if(e.getSource() == b3){
				tf3.setText(s) ;
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					// 엑셀 파일을 문자열로 읽어온다.
					_excelreader = new ExcelReader(file, _xwb) ;
					try {
						_excelreader.read();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					tf3.setText(file.getPath());
				}
			}else if(e.getSource() == br){
				_xwb.outputXwb() ;
				JOptionPane.showMessageDialog(null, "생성완료!");
				System.out.print("> Program Exit ");
				System.exit(0) ;
			}

		}
	}
	class resultButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			_xwb.outputXwb() ;
			System.exit(1) ;

		}

	}

}
