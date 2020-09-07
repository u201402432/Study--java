
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
public class GUI 
{

	// �ν��Ͻ� ������ ����ϱ� ���� start�޼����0 ������ ���½��ϴ�. �ֳĸ� �̺�Ʈ �߻��� �̺�Ʈ �޼��忡�� ���Ǳ� �����Դϴ�.
	private JTextField tf1 = new JTextField(40); // �ؽ�Ʈ �ʵ� ����
	private JTextField tf2 = new JTextField(40); 
	private JTextField tf3 = new JTextField(40);

	private JButton b1 = new JButton("�����߰�");	// �����߰� ��ư�Դϴ�.
	private JButton b2 = new JButton("�����߰�");
	private JButton b3 = new JButton("�����߰�");
	private JButton br = new JButton("�׷콺���ٷ� ����"); 

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

		JLabel l1 = new JLabel("���ϰ��");	// �ؽ�Ʈ�ʵ�տ� �������ֱ� ���� ���̺��� �߰��Ͽ����ϴ�.
		JLabel l2 = new JLabel("���ϰ��");
		JLabel l3 = new JLabel("���ϰ��");

		//setLayout���� �� ��ư�� �������� ��ġ �ϵ��� �����մϴ�.

		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 4 , 4));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 4 , 4));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 4 , 4));
		panelr.setLayout(new FlowLayout(FlowLayout.CENTER,4, 4));
		// �������� ������ �гε��� ���� �������� �迭 �� ���ֵ��� �����ִϴ�.
		panelVer.setLayout(new BoxLayout(panelVer,BoxLayout.Y_AXIS));
		//�� panel1,2,3 ���� ��ư�� �ؽ�Ʈ �ʵ带 ��ġ
		panel1.add(l1); //ù��° ���� ������Ʈ
		panel1.add(tf1);
		panel1.add(b1);

		panel2.add(l2);//�ι�° ���� ������Ʈ
		panel2.add(tf2);
		panel2.add(b2);

		panel3.add(l3);//����° ���� ������Ʈ
		panel3.add(tf3);
		panel3.add(b3);

		panelr.add(br);//��¹�ư�� ���� ������Ʈ

		panelVer.add(panel1);//�� ���� �������� ���� ���� �г�
		panelVer.add(panel2);
		panelVer.add(panel3);

		frame.getContentPane().add(BorderLayout.CENTER,panelVer);
		frame.getContentPane().add(BorderLayout.SOUTH,panelr);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(630, 200);
		frame.setVisible(true);

		//button event�� �о��� Lister
		b1.addActionListener(new fileButtonListener());
		b2.addActionListener(new fileButtonListener());
		b3.addActionListener(new fileButtonListener());
		br.addActionListener(new fileButtonListener());
	}

	//////////////////////////////////
	//���� Ŭ���� ���·� �ΰ��� �̺�Ʈ�� �����ϰڽ��ϴ�.
	//�ϳ��� �����߰� ��ư�鿡 ���� �̺�Ʈ
	//�ϳ��� �����¿� ���� �̺�Ʈ ������ ����Ŭ������ �����س��� �����ϰڽ��ϴ�.
	class fileButtonListener implements ActionListener
	{

		// �����߰� ��ư�� ���� �̺�Ʈ ���Դϴ�.
		// ActionEvent Ŭ������ getSource() �޼��带 ����Ͽ�
		// �ش� �̺�Ʈ�� �߻��� ��ü�� Reference ������ �ּҿ� ��ġ�Ѵٸ� �ش� ��ư�� �ִ� Panel�� textfield���� String�� set�մϴ�.
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//���⿡ �����  String��
			String s = "������ �߰��ϼ���.";

			if(e.getSource() == b1){
				tf1.setText(s) ;
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{

					File file = fc.getSelectedFile();

					// ���� ������ ���ڿ��� �о�´�.
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
				//���⿡ �����  String��
				tf2.setText(s) ;

				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();

					// ���� ������ ���ڿ��� �о�´�.
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
					// ���� ������ ���ڿ��� �о�´�.
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
				JOptionPane.showMessageDialog(null, "�����Ϸ�!");
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
