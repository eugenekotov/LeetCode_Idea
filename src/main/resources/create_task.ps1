Write-Host "Input task number"
$taskNumber = Read-Host "Input task number"

if (-not ($taskNumber -match "^\d{4}$")) {
    Write-Host "Incorrect task number."
    Write-Host "Script finished."
    exit
}


$taskFolder = "task_$taskNumber"
$path = "$PSScriptRoot\..\java\com\leetcode\inprogress\$taskFolder"
# $path = Resolve-Path "$PSScriptRoot\..\java\com\leetcode\inprogress\task_$taskNumber"


if (Test-Path $path) {
    Write-Host "Folder '$taskFolder' already exists."
    Write-Host "Script finished."
    exit
}

# Create task folder
Write-Host "Create folder '$taskFolder'."
New-Item -ItemType directory -Path $path >$null 2>&1

# Create file Solution.java
New-Item -ItemType file -Path "$path\Solution.java" -Force

# Add content to Solution.java
Add-Content -Path "$path\Solution.java" -Value "package com.leetcode.inprogress.task_$taskNumber;"
Add-Content -Path "$path\Solution.java" -Value ""
Add-Content -Path "$path\Solution.java" -Value "public class Solution {"
Add-Content -Path "$path\Solution.java" -Value ""
Add-Content -Path "$path\Solution.java" -Value "}"


# Create file MainClass.java
$mainClassFile = "MainClass_$taskNumber.java"
New-Item -ItemType file -Path "$path\$mainClassFile" -Force

# Add content to MainClass.java
Add-Content -Path "$path\$mainClassFile" -Value "package com.leetcode.inprogress.task_$taskNumber;"
Add-Content -Path "$path\$mainClassFile" -Value ""
Add-Content -Path "$path\$mainClassFile" -Value "public class MainClass_$taskNumber {"
Add-Content -Path "$path\$mainClassFile" -Value ""
Add-Content -Path "$path\$mainClassFile" -Value "    private static final Solution solution = new Solution();"
Add-Content -Path "$path\$mainClassFile" -Value ""
Add-Content -Path "$path\$mainClassFile" -Value "    public static void main(String[] args) {"
Add-Content -Path "$path\$mainClassFile" -Value "    }"
Add-Content -Path "$path\$mainClassFile" -Value ""
Add-Content -Path "$path\$mainClassFile" -Value "}"


Write-Host "Script finished."
