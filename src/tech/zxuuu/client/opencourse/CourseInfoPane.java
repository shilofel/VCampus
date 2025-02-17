package tech.zxuuu.client.opencourse;

import javax.swing.JPanel;

import tech.zxuuu.util.SwingUtils;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 公开课课程信息Block
 * 
 * @author LongChen
 */
public class CourseInfoPane extends JPanel {

	public static final int HEIGHT = 130;
	private int id; // 课程ID
	private String preview; // 预览图链接
	private String courseName; // 课程名称
	private String speaker; // 主讲人名称
	private JEditorPane epnPreview;
	private JLabel lblCourseName;
	private JLabel lblSpeaker;
	public String videoUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	/**
	 * Create the panel.
	 */
	public CourseInfoPane() {
		
		
		epnPreview = new JEditorPane();
		epnPreview.setContentType("text/html");
		epnPreview.setEditable(false);
		epnPreview.setBounds(0, 0, 127, 113);
		add(epnPreview);

		this.lblCourseName = new JLabel("这里是课程名");
		lblCourseName.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		lblCourseName.setBounds(129, 0, 477, 58);
		add(lblCourseName);

		this.lblSpeaker = new JLabel("这里是主讲人");
		lblSpeaker.setFont(new Font("宋体", Font.PLAIN, 35));
		lblSpeaker.setBounds(135, 72, 421, 41);
		add(lblSpeaker);

		JButton btnNewButton = new JButton("进入");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					StuCourseGUI stuCourseGUI = new StuCourseGUI(id, videoUrl);
					stuCourseGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					stuCourseGUI.setVisible(true);
				} catch (Exception e1) {
					SwingUtils.showError(null, "视频启动失败，请检查VLC安装！", "错误");
				}
			}
		});
		btnNewButton.setBounds(584, 80, 99, 41);
		add(btnNewButton);
		
		setLayout(null);
		setVisible(true);
	}

	public CourseInfoPane(int id, String courseName, String speaker, String preview, String videoUrl) {
		this();
		this.id = id;
		this.preview = preview;
		this.courseName = courseName;
		this.speaker = speaker;
		this.videoUrl = videoUrl;
		this.epnPreview.setText(this.preview);
		this.lblCourseName.setText(this.courseName);
		this.lblSpeaker.setText(this.speaker);
		this.validate();
		this.repaint();
		this.updateUI();
		this.revalidate();
	}
}
