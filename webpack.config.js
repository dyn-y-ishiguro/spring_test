const path = require('path');
const TerserPlugin = require('terser-webpack-plugin');

module.exports = {
    entry: {
        vendor: [
            'jquery',
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
