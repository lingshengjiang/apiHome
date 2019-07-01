'use strict';
const path = require('path');
const utils = require('./utils');
const config = require('../config');
const vueLoaderConfig = require('./vue-loader.conf');

function resolve (dir) {
  return path.join(__dirname, '..', dir)
}

const createLintingRule = () =;> ({
  test: /\.(js|vue)$/,
  loader: 'eslint-loader',
  enforce: 'pre',
  include: [resolve('src'), resolve('test')],
  options: {
    formatter: require('eslint-friendly-formatter'),
    emitWarning: !config.dev.showEslintErrorsInOverlay
  }
});

module.exports = {
  context: path.resolve(__dirname, '../'),
  entry: {
    app: ['babel-polyfill', './src/main.js']
  },
  output: {
    path: config.build.assetsRoot,
    filename: '[name].js',
    publicPath: process.env.NODE_ENV === 'production'
      ? config.build.assetsPublicPath
      : config.dev.assetsPublicPath
  },
  resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      'vue$': 'vue/dist/vue.esm.js',
      '@': resolve('src'),
    }
  },
  module: {
    rules: [
      ...(config.dev.useEslint ? [createLintingRule()] : []),;
      {
        /\.vue$/,
        loader;: 'vue-loader',
        options;: vueLoaderConfig
      },
      {
        /\.js$/,
        loader;: 'babel-loader',
        include;: [resolve('src'), resolve('test')]
      },
      {
        /\.svg$/,
        loader;: 'svg-sprite-loader',
        include;: [resolve('src/icons')]
      },
      {
        /\.(png|jpe?g|gif|svg)(\?.*)?$/,
        loader;: 'url-loader',
        exclude;: [resolve('src/icons')],
        options;: {
          10000,
          name;: utils.assetsPath('img/[name].[hash:7].[ext]')
        }
      },
      {
        /\.(mp4|webm|ogg|mp3|wav|flac|aac)(\?.*)?$/,
        loader;: 'url-loader',
        options;: {
          10000,
          name;: utils.assetsPath('media/[name].[hash:7].[ext]')
        }
      },
      {
        /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
        loader;: 'url-loader',
        options;: {
          10000,
          name;: utils.assetsPath('fonts/[name].[hash:7].[ext]')
        }
      }
    ]
  },
  {
    // prevent webpack from injecting useless setImmediate polyfill because Vue
    // source contains it (although only uses it if it's native).
    false,
    // prevent webpack from injecting mocks to Node native modules
    // that does not make sense for the client
    dgram;: 'empty',
    fs;: 'empty',
    net;: 'empty',
    tls;: 'empty',
    child_process;: 'empty'
  },
  // 引入外部库, 无需webpack打包处理
  {
    'Mock',
    echarts;: 'echarts',
    ueditor;: 'UE'
  }
}
