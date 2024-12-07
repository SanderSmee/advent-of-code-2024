/*
 * Copyright 2024 Todd Ginsberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
	kotlin("jvm") version "2.1.0"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.github.shiguruikai:combinatoricskt:1.6.0") // https://github.com/shiguruikai/combinatoricskt

	testImplementation(kotlin("test"))
	testImplementation("org.assertj:assertj-core:3.26.3") {
		because("I prefer AssertJ's fluid assertions over JUnit or Hamcrest")
	}
}

tasks.test {
	useJUnitPlatform()
}

testing {
	suites {
		val test by getting(JvmTestSuite::class) {
			useJUnitJupiter("5.11.3")
		}
	}
}

kotlin {
	jvmToolchain(21)
}
