package com.vikde.gradle.publisher.tasks

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

/**
 * @author vikde
 * @date 2018/9/19
 */
class CopyLibsTask extends Copy {
    CopyLibsTask() {
        group = "vikde"
        from(project.configurations.getByName('runtime'))
        into(project.buildDir.path + File.separator + project.buildType + File.separator + 'libs')
    }

    @TaskAction
    def copyLibs() {}
}
