# CMD Simulator in Kotlin

## Overview
 This project is a student project of a Kotlin-based command-line tool that simulates the basic functionality of the Windows Command Prompt (cmd). While it replicates many cmd commands, it does not aim to exactly match the behavior of Windows cmd. Certain commands and details may differ. 🌟

The goal is to create an interactive terminal environment for exploring file operations and directory navigation using Kotlin. 🚀

## Features

### Supported Commands
1. **`echo.`**
   - Creates a new file.
   - Usage: `echo. <path_to_file>`

2. **`ren`**
   - Renames or changes the format of a file.
   - Usage: `ren <current_file_path> <target_name>`

3. **`del`**
   - Deletes a file.
   - Usage: `del <path_to_file>`

4. **`cd`**
   - Displays or changes the current directory.
   - Usage:
     - `cd`: Displays the current directory.
     - `cd <folder_name>`: Changes to the specified folder.
     - `cd ..`: Moves to the parent directory.
     - `cd \`: Moves to the root of the current drive.
     - `cd <absolute_path>`: Changes to the specified absolute path.

5. **`dir`**
   - Lists files and folders in the current directory.
   - Displays creation time, size, and type (directory or file).

6. **`exit`**
   - Exits the program.

7. **`help`**
   - Lists available commands and their usage.

8. **Drive Change**
   - Switches between drives.
   - Usage: `<drive_letter>:` (e.g., `E:`).

### Command Examples
🔠 Create a file: `echo. C:\Users\example.txt` 🎮
- Rename a file: `ren C:\Users\example.txt new_example.txt` ✍️
- Delete a file: `del C:\Users\example.txt` 🗑️
- Change to a folder: `cd Documents` 📚
- Move to parent directory: `cd ..` ⏫
- List contents of the directory: `dir` 🗃

### Output Formatting
- File listing includes creation time, size, and type (e.g., `<DIR>` for directories).
- Example:
  ```
  12-14-2024  15:30:00     <DIR>       0          Documents
  12-13-2024  10:20:45                2048       example.txt
  ``` ✨

## Installation
⚡️ 1. Clone this repository to your local machine:
   ```
   git clone <repository_url>
   ``` 🚨
2. Open the project in your preferred Kotlin IDE (e.g., IntelliJ IDEA).
3. Build and run the `main` function in `Main.kt`. 🌌

## Known Limitations
💡 **File Permissions:** The program may fail to execute certain file operations due to restricted permissions. 🗒
- **Exact cmd Behavior:** Commands like `echo.` and `cd` do not perfectly mimic Windows cmd. 🏁
- **Error Handling:** Limited error handling for invalid inputs or system errors. 🔍

## Future Improvements
- Add support for additional cmd commands (e.g., `copy`, `move`, `mkdir`). ✨
- Enhance error handling and user feedback for invalid inputs. 🔧
- Include support for piping and chaining commands. ➡️
- Improve cross-platform compatibility (e.g., Linux, macOS). ⚡
- Add a `config` file for user-defined settings. 🗄

## Contributing
📚 Contributions are welcome! If you'd like to improve this project, please follow these steps: ✍️
1. Fork the repository. 🌐
2. Create a new branch:
   ```
   git checkout -b feature/your-feature-name
   ``` ♻️
3. Commit your changes:
   ```
   git commit -m "Add some feature"
   ``` ⌚
4. Push to the branch:
   ```
   git push origin feature/your-feature-name
   ``` 🏢
5. Open a pull request. 🎉

## License
💎 This project is licensed under the MIT License. Feel free to use, modify, and distribute it. ✨

---

✨ Enjoy building your own command-line simulator! ✨

