package ui;

import javax.swing.*;

public class PostListForm extends JFrame
{
    private JTable tablePost;
    private JPanel rootPanel;

    public PostListForm()
    {
        super();

        this.setContentPane( rootPanel);
        this.setSize( 250, 250 );
        this.setVisible( true );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }
}
