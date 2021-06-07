const path = require('path');
const TerserPlugin = require('terser-webpack-plugin');

module.exports = {
    entry: {
        vendor: [
            'jquery',
        ],
        i18next: [
            path.resolve(__dirname, 'src/main/js/i18next_dic_ja.js'),
            path.resolve(__dirname, 'src/main/js/i18next_dic_en.js'),
            path.resolve(__dirname, 'src/main/js/i18next_init.js'),
        ],
        screen1: path.resolve(__dirname, "src/main/js/screen1.js"),
        screen2: path.resolve(__dirname, "src/main/js/screen2.js"),
        hello: path.resolve(__dirname, "src/main/js/hello.js"),
    },
    output: {
        path: path.resolve(__dirname, 'src/main/resources/static/js'),
        filename: '[name].bundle.js',
    },
    optimization: {
        minimizer: [
            new TerserPlugin({
                extractComments: false,
            }),
        ],
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js',
        }
    },
};
