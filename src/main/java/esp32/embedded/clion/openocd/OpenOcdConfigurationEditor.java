package esp32.embedded.clion.openocd;

import com.intellij.execution.ui.CommonProgramParametersPanel;
import com.intellij.openapi.project.Project;
import com.intellij.util.ui.GridBag;
import com.jetbrains.cidr.cpp.execution.CMakeAppRunConfigurationSettingsEditor;
import com.jetbrains.cidr.cpp.execution.CMakeBuildConfigurationHelper;
import java.awt.Component;
import javax.swing.JPanel;
import org.jetbrains.annotations.NotNull;

public class OpenOcdConfigurationEditor extends CMakeAppRunConfigurationSettingsEditor {

    public static final String BOOTLOADER_FILE = "Bootloader file";
    public static final String PART_TABLE_FILE = "Partition Table file";

    public OpenOcdConfigurationEditor(Project project,
                                      @NotNull CMakeBuildConfigurationHelper cMakeBuildConfigurationHelper) {
        super(project, cMakeBuildConfigurationHelper);
    }

    @Override
    protected void createEditorInner(JPanel panel, GridBag gridBag) {
        super.createEditorInner(panel, gridBag);

        for (Component component : panel.getComponents()) {
            if (component instanceof CommonProgramParametersPanel) {
                component.setVisible(false);//todo get rid of this hack
            }
        }
    }
}
