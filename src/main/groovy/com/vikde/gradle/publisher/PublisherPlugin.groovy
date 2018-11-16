package com.vikde.gradle.publisher


import com.vikde.gradle.publisher.tasks.CopyConfigTask
import com.vikde.gradle.publisher.tasks.CopyJarTask
import com.vikde.gradle.publisher.tasks.CopyLibsTask
import com.vikde.gradle.publisher.tasks.CopyShellTask
import com.vikde.gradle.publisher.tasks.FatJarTask
import com.vikde.gradle.publisher.tasks.PublishTask
import com.vikde.gradle.publisher.tasks.ZipAllTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * @author vikde
 * @date 2018/9/18
 */
class PublisherPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        //任务创建
        Task copyConfigTask = project.tasks.create('copyConfig', CopyConfigTask)
        Task copyJarTask = project.tasks.create('copyJar', CopyJarTask)
        Task copyLibsTask = project.tasks.create('copyLibs', CopyLibsTask)
        Task copyShellTask = project.tasks.create('copyShell', CopyShellTask)
        Task zipAllTask = project.tasks.create('zipAll', ZipAllTask)
        Task publishTask = project.tasks.create('publish', PublishTask)
        Task fatJarTask = project.tasks.create('fatJar', FatJarTask)

        //根据是否为fatJar适配不一样的编译逻辑
        if (!project.hasProperty('isFatJar') || project.isFatJar == null || project.isFatJar == false) {
            publishTask.dependsOn zipAllTask
            zipAllTask.dependsOn copyShellTask
            copyShellTask.dependsOn copyLibsTask
            copyLibsTask.dependsOn copyJarTask
            copyJarTask.dependsOn copyConfigTask
            copyConfigTask.dependsOn 'build'
        } else {
            publishTask.dependsOn zipAllTask
            zipAllTask.dependsOn copyShellTask
            copyShellTask.dependsOn fatJarTask
            fatJarTask.dependsOn 'classes'
        }
    }
}
