System.config({
    transpiler: 'typescript',
    map: {
      app: '/build/app'
    },
    packages: {
        app: {
        format: 'register',
        defaultExtension: 'js'
        }
    }
});