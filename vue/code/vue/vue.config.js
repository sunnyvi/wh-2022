const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
 transpileDependencies: true,
  devServer: {
  //  disableHostCheck: false,
    host: '0.0.0.0',
    port: 8095,
    https: false,
  //  hotOnly: false,
    proxy: null
  },

})
/*
module.exports = defineConfig({
  devServer: {
    port: 80,
    host: '0.0.0.0',
  },
});
*/

