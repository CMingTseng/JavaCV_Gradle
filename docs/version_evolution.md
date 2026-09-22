# JavaCV 專案版本沿革與依賴變更紀錄

本文件紀錄了本專案子模組 `javacv` 從舊版同步至官方最新版本時的依賴庫版本演革，以及對應的 Git Commit SHA 資訊。

---

## 1. Git Commit SHA 對應資訊

| 項目 | Git Commit SHA | 說明 |
| :--- | :--- | :--- |
| **同步前 (Previous)** | `ce447cf42cba402e0da2664242a9cf016c05e0be` | 原本專案所指針之舊版子模組 Commit (Add FUNDING.yml file) |
| **同步後 (Current HEAD)** | `d6b38e57e0a767cb9ab0448f102b4e6396275d2e` | 同步官方最新 upstream 後的 Commit (Update version in pom.xml to 1.5.15-SNAPSHOT) |

---

## 2. Bytedeco 核心與預設版本變更 (JavaCPP)

* **JavaCPP / JavaCV 主版本**：從 `1.5.13-SNAPSHOT` 升級至 **`1.5.15-SNAPSHOT`**

---

## 3. 核心原生平台庫依賴變更 (格式為：庫版本-JavaCPP版本)

| 依賴庫名稱 (Artifact) | 舊版本 (Old Version - `ce447cf`) | 新版本 (New Version - `d6b38e5`) | 狀態 / 處理建議 |
| :--- | :--- | :--- | :--- |
| **`openblas`** | `0.3.30-1.5.13-SNAPSHOT` | **`0.3.34-1.5.15-SNAPSHOT`** | 建議隨 `pom.xml` 全域同步更新 |
| **`opencv`** (包含 gpu 平台) | `4.12.0-1.5.13-SNAPSHOT` | **`4.14.0-1.5.15-SNAPSHOT`** | 建議隨 `pom.xml` 全域同步更新 |
| **`ffmpeg`** (包含 gpl 平台) | `8.0-1.5.13-SNAPSHOT` | **`8.1.2-1.5.15-SNAPSHOT`** | 建議隨 `pom.xml` 全域同步更新 |
| **`leptonica`** | `1.85.0-1.5.13-SNAPSHOT` | **`1.87.0-1.5.15-SNAPSHOT`** | 建議隨 `pom.xml` 全域同步更新 |
| **`tesseract`** | `5.5.1-1.5.13-SNAPSHOT` | **`5.5.3-1.5.15-SNAPSHOT`** | 建議隨 `pom.xml` 全域同步更新 |

---

## 4. 其他關聯第三方庫變更

| 依賴庫名稱 (Artifact) | 舊版本 (Old Version) | 新版本 (New Version) | 說明 |
| :--- | :--- | :--- | :--- |
| **`org.jogamp.gluegen`** | `2.3.2` | **`2.6.0`** | 執行期與膠水程式優化升級 |
| **`org.jogamp.jogl`** | `2.3.2` | **`2.6.0`** | 執行期與膠水程式優化升級 |
| **`org.jogamp.jocl`** | `2.3.2` | **`2.6.0`** | 執行期與膠水程式優化升級 |
| **`com.badlogicgames.gdx`** | `1.13.1` | **`1.14.0`** | 遊戲/圖形核心引擎升級 |
| **`org.openjfx`** | JavaFX 21 | **JavaFX 25 (新增)** | 新增對 JDK 25 的 Profile 編譯支援 |

---

## 5. 專案版本混用分析與標注 (Mixed Versions Analysis)

原本在主專案 `gradle/libs.versions.toml` 中，存在以下舊版 **`1.5.12`** 混用的情況：
```toml
org-bytedeco-ffmpeg-platform-gpl = "7.1.1-1.5.12"
org-bytedeco-javacv-platform = "1.5.12"
org-bytedeco-opencv-platform-gpu = "4.11.0-1.5.12"
```

### 標注與潛在風險模組：
1. **`:samples:RealSense2DepthMeasuring`**
   * **標注原因**：該模組的 `build.gradle` 內特別留有註解 `//FIXME must fix version use old javacv !!` 且設定其本身的 `version = '1.5.12'`。
   * **分析結果**：經查證，其實際上也是依賴全域的 `libs.org.bytedeco.javacv.platform`。RealSense 2 的底層原生庫（如 `librealsense2 = "2.53.1-1.5.9"`) 在本次官方的 `pom.xml` 升級中**並未被變更**。
   * **處理方案**：如果測試中發現該模組對新版 `1.5.15-SNAPSHOT` 產生相容性問題，必須將其依賴改為 **Hardcode 舊版** 以進行隔離：
     ```groovy
     // 如果全域更新後不相容，可單獨在該模組 hardcode 舊版：
     implementation("org.bytedeco:javacv-platform:1.5.12")
     ```

2. **全域同步方針**：
   * 原本的 `1.5.12` 混用為歷史殘留設定。既然 `javacv` 子模組已全面對齊官方最新 `1.5.15-SNAPSHOT` 規範（其 `platform/pom.xml` 內明確指出 `ffmpeg-platform-gpl` 為 `8.1.2-1.5.15-SNAPSHOT`，`opencv-platform-gpu` 為 `4.14.0-1.5.15-SNAPSHOT`），大多數模組應一併同步至最新。
