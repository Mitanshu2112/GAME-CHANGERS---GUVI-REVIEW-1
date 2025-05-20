import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;


public class AddAccountFrame extends JFrame{

	private AddAccountPanel addAccountPanel;
	
	public AddAccountFrame(){
		super("Select the Account Type");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addAccountPanel = new AddAccountPanel();
		addAccountPanel.setBackground(Color.PINK);
		this.setLocation(500, 500);
		add(addAccountPanel);
	}
	
	public boolean getSavings(){
		return addAccountPanel.getSavings();
	}
	
	public void setSavingsFalse(){
		addAccountPanel.setSavingsFalse();
	}
	
	public boolean getChecking(){
		return addAccountPanel.getChecking();
	}
	
	public void setCheckingFalse(){
		addAccountPanel.setCheckingFalse();
	}
}