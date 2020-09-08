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

## License
MIT License

Copyright (c) 2020 Yusuke Hasegawa

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.