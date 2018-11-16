package com.vikde.gradle.publisher.tasks

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

/**
 * @author vikde
 * @date 2018/9/19
 */
class CopyJarTask extends Copy {
    CopyJarTask() {
        group = "vikde"
        doLast {
            from(project.buildDir.path + File.separator + 'libs' + File.separator + project.name + '-' + project.version + '.jar')
            into(project.buildDir.path + File.separator + project.buildType)
        }
    }

    @TaskAction
    def copyJar() {}
}
