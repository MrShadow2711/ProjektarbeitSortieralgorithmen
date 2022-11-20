import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Frame extends JFrame{
      
      private JPanel[] pages = new JPanel[3];
      private int currentPage;
      
      public Frame() {
            createPages();
            currentPage = 0;
            
            setTitle("Test");
            setSize(300,200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            
            this.add(pages[0]);
            this.revalidate();
            this.repaint();
            
      }
      
      private void nextPage() {
            this.remove(pages[currentPage]);
            
            currentPage++;
            this.add(pages[currentPage]);
            
            this.revalidate();
            this.repaint();
      }
      
      private void createPages() {
            createPage0();
            createPage1();
            createPage2();
            createPage3();
            //createPage4();
      }
      
      private void createPage0() {
            JPanel panel = new JPanel();
            
            JButton b = new JButton("Test");
            b.addActionListener(new ActionListener() {
                  
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        nextPage();
                        
                  }
            });
            panel.add(b);
            
            pages[0] = panel;
      }
      
      private void createPage1() {
            JPanel panel = new JPanel();
            
            JButton b = new JButton("Hallo");
            b.addActionListener(new ActionListener() {
                  
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.exit(EXIT_ON_CLOSE);
                        
                  }
            });
            panel.add(b);
            
            pages[1] = panel;
      }

      private void createPage2() {
            
      }

      private void createPage3() {
            
      }

      private void createPage4() {
            JPanel panel = new JPanel();
            
            int[] sortedArray = Main.getSortedArray();
            String sortedString = Arrays.toString(sortedArray);
      }
      
}
