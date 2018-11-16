package com.vikde.gradle.publisher.tasks

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

/**
 * @author vikde
 * @date 2018/9/19
 */
class CopyShellTask extends Copy {
    CopyShellTask() {
        group = "vikde"
        filteringCharset = "UTF-8"
        from(project.buildDir.path + File.separator + 'resources' + File.separator + 'main')
        into(project.buildDir.path + File.separator + project.buildType)
        include("*.sh", "*.bat", "*/*.sh", "*/*.bat")
    }

    @TaskAction
    def copyShell() {}
}
