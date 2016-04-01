System.config({
    transpiler: 'typescript',
    typescriptOptions: { emitDecoratorMetadata: true },
    "paths": {
    "main": "/main",
    "angular2/": "/angular2/",
    "rxjs/": "/rxjs/",
    "moment/": "/node_modules/moment/moment",
    "": "/node_modules/",
    "angular2-jwt": "/node_modules/angular2-jwt/angular2-jwt",
    "ng2-charts": "/node_modules/ng2-charts"
},
    packages: {'app': {defaultExtension: 'ts'}}
});



