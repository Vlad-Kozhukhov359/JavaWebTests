[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
chcp 65001 | Out-Null
.\gradlew.bat test --tests EnterUsernameOnlyTests
