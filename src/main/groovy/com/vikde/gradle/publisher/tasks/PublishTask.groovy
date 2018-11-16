package com.vikde.gradle.publisher.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * @author vikde
 * @date 2018/9/19
 */
class PublishTask extends DefaultTask {
    PublishTask() {
        super()
        group = "vikde"
    }

    @TaskAction
    def publish() {
        System.out.println("====================================")
        System.out.println("打包环境:" + project.buildType)
        System.out.println("打包路径:" + project.buildDir.path + File.separator + project.buildType + File.separator)
        System.out.println("打包文件:" + project.name + '-' + project.buildType + '-' + project.version + '.zip')
        System.out.println("打包完成")
        System.out.println("====================================")
    }
}

