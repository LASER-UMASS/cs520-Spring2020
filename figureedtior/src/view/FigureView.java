package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import model.FigureModel;
import controller.FigureController;


public class FigureView implements View
{
    JPanel figurePanel;
    JLabel imageView;
    JButton changeImageButton;
    JLabel captionView;
    JButton editCaptionButton;


    public FigureView() {
	super();

	this.figurePanel = new JPanel(new GridLayout(2,1));

	JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	this.imageView = new JLabel();
	imagePanel.add(this.imageView);
	this.changeImageButton = new JButton("Change image...");
	this.changeImageButton.setSize(125, 75);
	imagePanel.add(this.changeImageButton);
	this.figurePanel.add(imagePanel);

	JPanel captionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	this.captionView = new JLabel();
	this.captionView.setSize(500, 75);
	captionPanel.add(this.captionView);	
	this.editCaptionButton = new JButton("Edit caption...");
	this.editCaptionButton.setSize(125, 75);
	captionPanel.add(this.editCaptionButton);
	this.figurePanel.add(captionPanel);
    }

    public JPanel getPanel() {
	return this.figurePanel;
    }

    public void addController(final FigureController controller) {
	this.changeImageButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        controller.changeImage();
	    }
	});

	this.editCaptionButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		controller.editCaption();
	    }
	});
    }

    public void update(FigureModel model) {
	if (model.getImage() != null) {
	    this.imageView.setIcon(model.getImage());
	}
	if (model.getCaption() != null) {
	    this.captionView.setText(model.getCaption());
	}
    }
}
