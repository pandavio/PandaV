# PandaV B4X App - NFT Access Control Client

PandaV 是一款结合区块链身份认证与门禁系统的移动客户端，基于 **B4A (Basic4Android)** 开发，支持通过 **ErgoPay** 使用 Ergo 钱包登录，并与后台绑定钱包地址、卡号或 NFT，实现区块链门禁功能。

PandaV is a blockchain-based mobile access app built with **B4A (Basic4Android)**. It supports **ErgoPay login** with Ergo wallets, allowing users to bind wallet addresses to access sessions, cards, or NFTs.

---

## 📲 核心功能 | Features

- ✅ 支持 Ergo 钱包登录（ErgoPay 协议）
- ✅ 显示钱包余额与 NFT 列表
- ✅ 绑定门禁卡号与钱包地址
- ✅ 扫描二维码实现门禁验证
- ✅ 自动识别钱包地址并通过后端验证开门
- ✅ 支持区块链上记录开门交易（可选）

---

## 🔧 项目结构 | Project Structure

- `Main.bas` → 启动页面与页面导航
- `LoginHelper.bas` → 创建 session + 生成 ErgoPay 登录链接
- `NFTDetailPage.bas` → 展示 NFT 信息与二维码
- `B4XPages` → 多页面架构支持（推荐使用 B4XPages）

---

## 🚀 启动步骤 | How to Run

1. 打开 B4A IDE 并载入本项目
2. 确保启用了 `HttpUtils2`, `XUI`, `B4XLoadingIndicator`, `QRCodeGenerator` 等库
3. 修改 `Starter.bas` 中的服务器地址，例如：

```vb
Public ServerURL As String = "http"
```

4. 连接 Android 设备并运行项目

---

## 🌐 后端接口 | Backend Integration

该应用需配合 PandaV 后端服务使用，后端源码请参考：

🔗 https://github.com/pandavio/pdvserver

---

## 📦 示例配置 | Sample Config

```vb
' Starter.bas
Public CurrentSessionId As String
Public LoginSessionId As String
Public ServerURL As String = "http"
```

---

## 🧠 致谢 | Credits

开发：PandaV 团队  
后端：基于 [ErgoPay + Spring Boot](https://ergoplatform.org)  
前端：B4X (Basic4Android)
