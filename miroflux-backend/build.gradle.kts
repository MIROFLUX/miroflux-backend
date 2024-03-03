buildscript {
	repositories {
		mavenLocal()
		mavenCentral()
	}
}

plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

allprojects {
	group = "com.miroflux"
	version = "0.0.1-SNAPSHOT"
//	java {
//		sourceCompatibility = JavaVersion.VERSION_21
//	}

	repositories {
		mavenCentral()
		mavenLocal()
	}
}

subprojects {
	apply(plugin = "org.gradle.java")
	tasks.withType<JavaCompile> {
		options.encoding = "UTF-8"
	}
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.2")
		implementation("org.springframework.boot:spring-boot-starter-security:3.2.2")
		implementation("org.springframework.boot:spring-boot-starter-web:3.2.2")
		implementation("org.flywaydb:flyway-core:9.16.3")
		implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
		implementation("org.hibernate.javax.persistence:hibernate-jpa-2.0-api:1.0.0.Final")
		implementation("org.hibernate:hibernate-core:6.1.7.Final")
		compileOnly("org.projectlombok:lombok:1.18.28")
		runtimeOnly("org.postgresql:postgresql:42.2.24")
		annotationProcessor("org.projectlombok:lombok:1.18.28")
		testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.2")
	}

	repositories {
		mavenCentral()
		mavenLocal()
	}

}

configurations {
	named("compileOnly") {
		extendsFrom(configurations["annotationProcessor"])
	}
}

//group = "com.miroflux"
//version = "0.0.1-SNAPSHOT"
//
//java {
//	sourceCompatibility = JavaVersion.VERSION_21
//}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.flywaydb:flyway-core")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

	implementation(project(":miroflux-authentication-module"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
