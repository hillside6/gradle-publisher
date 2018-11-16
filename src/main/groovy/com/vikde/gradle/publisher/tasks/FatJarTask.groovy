package com.vikde.gradle.publisher.tasks

import org.gradle.jvm.tasks.Jar

/**
 * @author vikde
 * @date 2018/9/20
 */
class FatJarTask extends Jar {
    FatJarTask() {
        group = "vikde"
    }
}
