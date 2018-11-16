package com.vikde.gradle.publisher.tasks


import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.bundling.Zip

/**
 * @author vikde
 * @date 2018/9/19
 */
class ZipAllTask extends Zip {
    ZipAllTask() {
        group = "vikde"
        setDestinationDir(new File(project.buildDir.path + File.separator + project.buildType))
        setArchiveName(project.name + '-' + project.buildType + '-' + project.version + '.zip')
        from(project.buildDir.path + File.separator + project.buildType)
        into(project.name + '-' + project.version)
        exclude(project.name + '-' + project.buildType + '-' + project.version + '.zip')
    }

    @TaskAction
    def zipAll() {}
}