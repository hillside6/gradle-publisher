package com.vikde.gradle.publisher.tasks

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

/**
 * @author vikde
 * @date 2018/9/19
 */
class CopyConfigTask extends Copy {
    CopyConfigTask() {
        group = "vikde"
        from(project.buildDir.path + File.separator + 'resources' + File.separator + 'main')
        into(project.buildDir.path + File.separator + project.buildType + File.separator + 'config')
        include('*/*.properties', '*/*.xml', '*/*.txt', '*/*.json', '*.properties', '*.xml', '*.txt', '*.json')
    }

    @TaskAction
    def copyConfig() {}
}
