enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
        mavenCentral()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
            name = "SonatypeSnapshots"
            mavenContent {
                snapshotsOnly()
            }
        }
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
        maven(url = "https://repo.maven.apache.org/maven2/")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin/")
        maven(url = "https://maven.aliyun.com/repository/spring-plugin/")
        maven(url = "https://jitpack.io")
        maven(url = "https://s3.amazonaws.com/repo.commonsware.com")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://api.xposed.info/")
        maven(url = "https://jogamp.org/deployment/maven")
        maven(url = "https://developer.huawei.com/repo/")
        maven(url = "https://raw.githubusercontent.com/cybernhl/maven-repository/master/")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/public/")
        maven(url = "https://maven.aliyun.com/repository/spring/")
        maven(url = "https://maven.aliyun.com/repository/google/")
        maven(url = "https://maven.aliyun.com/repository/grails-core/")
        maven(url = "https://maven.aliyun.com/repository/apache-snapshots/'")
    }
    plugins {

    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

val fullVersion = System.getProperty("java.version", "8.0.0")
val versionComponents = fullVersion
    .split(".")
    .take(2)
    .filter { it.isNotBlank() }
    .map { Integer.parseInt(it) }

val currentJdk = if (versionComponents[0] == 1) versionComponents[1] else versionComponents[0]

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
            name = "SonatypeSnapshots"
            mavenContent {
                snapshotsOnly()
            }
        }
        maven(url = "https://jitpack.io")
        maven(url = "https://s3.amazonaws.com/repo.commonsware.com")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://api.xposed.info/")
        maven(url = "https://jogamp.org/deployment/maven")
        maven(url = "https://raw.githubusercontent.com/cybernhl/maven-repository/master/")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/public/")
        maven(url = "https://maven.aliyun.com/repository/spring/")
        maven(url = "https://maven.aliyun.com/repository/google/")
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
        maven(url = "https://repo.maven.apache.org/maven2/")
    }
}

rootProject.name = "JavaCV"
include(":samples:AudioSplitMergeHelper")
project(":samples:AudioSplitMergeHelper").projectDir = file("./samples/AudioSplitMergeHelper")

include(":samples:BioInspiredRetina")
project(":samples:BioInspiredRetina").projectDir = file("./samples/BioInspiredRetina")

include(":samples:BlobDemo")
project(":samples:BlobDemo").projectDir = file("./samples/BlobDemo")

include(":samples:CaffeGooglenet")
project(":samples:CaffeGooglenet").projectDir = file("./samples/CaffeGooglenet")

include(":samples:ColoredObjectTrack")
project(":samples:ColoredObjectTrack").projectDir = file("./samples/ColoredObjectTrack")

include(":samples:DeepLearningFaceDetection")
project(":samples:DeepLearningFaceDetection").projectDir = file("./samples/DeepLearningFaceDetection")

include(":samples:Demo")
project(":samples:Demo").projectDir = file("./samples/Demo")

include(":samples:FaceApplet")
project(":samples:FaceApplet").projectDir = file("./samples/FaceApplet")

include(":samples:FacePreview")
project(":samples:FacePreview").projectDir = file("./samples/FacePreview")

include(":samples:FaceRecognizerInVideo")
project(":samples:FaceRecognizerInVideo").projectDir = file("./samples/FaceRecognizerInVideo")

include(":samples:FFmpegStreamingTimeout")
project(":samples:FFmpegStreamingTimeout").projectDir = file("./samples/FFmpegStreamingTimeout")

include(":samples:HoughLines")
project(":samples:HoughLines").projectDir = file("./samples/HoughLines")

include(":samples:ImageSegmentation")
project(":samples:ImageSegmentation").projectDir = file("./samples/ImageSegmentation")

include(":samples:JavaFxPlayVideoAndAudio")
project(":samples:JavaFxPlayVideoAndAudio").projectDir = file("./samples/JavaFxPlayVideoAndAudio")

include(":samples:KazemiFacemarkExample")
project(":samples:KazemiFacemarkExample").projectDir = file("./samples/KazemiFacemarkExample")

include(":samples:LBFFacemarkExampleWithVideo")
project(":samples:LBFFacemarkExampleWithVideo").projectDir = file("./samples/LBFFacemarkExampleWithVideo")

include(":samples:MotionDetector")
project(":samples:MotionDetector").projectDir = file("./samples/MotionDetector")

include(":samples:OpenCVFaceRecognizer")
project(":samples:OpenCVFaceRecognizer").projectDir = file("./samples/OpenCVFaceRecognizer")

include(":samples:OpenCVFeatures2dSerialization")
project(":samples:OpenCVFeatures2dSerialization").projectDir = file("./samples/OpenCVFeatures2dSerialization")

include(":samples:OpticalFlowDense")
project(":samples:OpticalFlowDense").projectDir = file("./samples/OpticalFlowDense")

include(":samples:OpticalFlowTracker")
project(":samples:OpticalFlowTracker").projectDir = file("./samples/OpticalFlowTracker")

include(":samples:PacketRecorderTest")
project(":samples:PacketRecorderTest").projectDir = file("./samples/PacketRecorderTest")

include(":samples:PerspectiveWarpDemo")
project(":samples:PerspectiveWarpDemo").projectDir = file("./samples/PerspectiveWarpDemo")

include(":samples:PrincipalComponentAnalysis")
project(":samples:PrincipalComponentAnalysis").projectDir = file("./samples/PrincipalComponentAnalysis")

include(":samples:RealSense2DepthMeasuring")
project(":samples:RealSense2DepthMeasuring").projectDir = file("./samples/RealSense2DepthMeasuring")

include(":samples:RecordActivity")
project(":samples:RecordActivity").projectDir = file("./samples/RecordActivity")

include(":samples:RLSA")
project(":samples:RLSA").projectDir = file("./samples/RLSA")

include(":samples:Similarity")
project(":samples:Similarity").projectDir = file("./samples/Similarity")

include(":samples:Square")
project(":samples:Square").projectDir = file("./samples/Square")

include(":samples:TemplateMatching")
project(":samples:TemplateMatching").projectDir = file("./samples/TemplateMatching")

include(":samples:WebcamAndMicrophoneCapture")
project(":samples:WebcamAndMicrophoneCapture").projectDir = file("./samples/WebcamAndMicrophoneCapture")

include(":samples:YOLONet")
project(":samples:YOLONet").projectDir = file("./samples/YOLONet")

