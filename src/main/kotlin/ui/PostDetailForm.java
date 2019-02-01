package ui;

import javax.swing.*;

public class PostDetailForm extends JFrame{
    private JPanel rootPanel;
    private JLabel lblTitulo;
    private JLabel lblBody;

    public PostDetailForm( int id )
    {
        super();

        this.setContentPane( rootPanel);
        this.setSize( 500, 250 );
        this.setVisible( true );
    }
}
