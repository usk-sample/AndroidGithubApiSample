## API実装サンプル
Retrofitを使い、GitHub Search APIで検索するためのサンプルプロジェクトです。

### アプリ構成
- アーキテクチャ：Android MVVM（[参考](https://developer.android.com/jetpack/docs/guide?hl=ja)）
- ライブラリ：[Retrofit2](https://square.github.io/retrofit/),[OkHttp](https://square.github.io/okhttp/),[Moshi](https://github.com/square/moshi))

### クラス構成
- MainActivity
- MyViewModel
- GithubRetrofitProvider：Github用にセットアップしたRetrofitを提供
- GithubRepository：APIを実行
- GithubInterface：APIを定義
- SearchResponse：レスポンスの型

