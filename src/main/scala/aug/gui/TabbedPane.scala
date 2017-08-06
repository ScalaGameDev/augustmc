package aug.gui

import java.awt._
import javax.swing.border.EmptyBorder
import javax.swing.{JPanel, JTabbedPane}

import aug.profile.ProfileConfig
import aug.util.Util
import com.bulenkov.darcula.ui.DarculaTabbedPaneUI

class SystemPanel(mainWindow: MainWindow) extends JPanel with HasHighlight {
  setLayout(new GridLayout(1, 1))

  val textArea = new SplittableTextArea(ProfileConfig(""), this)
  val text: Text = textArea.text

  textArea.setActiveFont(Util.defaultFont)

  add(textArea)

  setBorder(new EmptyBorder(0, 0, 0, 0))
}

class TabbedPane(mainWindow: MainWindow) extends JTabbedPane {

  setUI(new DarculaTabbedPaneUI() {
    override def paintFocusIndicator(g: Graphics, tabPlacement: Int, rects: Array[Rectangle], tabIndex: Int,
                                     iconRect: Rectangle, textRect: Rectangle, isSelected: Boolean): Unit = {}
  })

  def active : Option[ProfilePanel] = {
    val c = getComponentAt(getSelectedIndex)
    c match {
      case panel: ProfilePanel => Some(panel)
      case _ => None
    }
  }

  def addProfile(name: String, profilePanel: ProfilePanel): Unit = {
    addTab(name, profilePanel)
    setSelectedComponent(profilePanel)
  }
}