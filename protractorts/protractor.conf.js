// Protractor configuration file, see link for more information
// https://github.com/angular/protractor/blob/master/docs/referenceConf.js

/*global jasmine */
var SpecReporter = require('jasmine-spec-reporter');
var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');

var reporter = new HtmlScreenshotReporter({
  dest: './screenshots',
  filename: 'my-report.html'
});

exports.config = {
    allScriptsTimeout: 11000,
    specs: [
        './e2e/**/*.e2e.ts'
    ],
    suites : {
        home: ['./e2e/suites/home.e2e.ts']
    },
    capabilities: {
        'browserName': 'chrome'
    },
    directConnect: true,
    baseUrl: 'http://localhost:4200/',
    framework: 'jasmine',
    jasmineNodeOpts: {
        showColors: true,
        defaultTimeoutInterval: 30000,
        print: function () {
        }
    },
    useAllAngular2AppRoots: true,
    beforeLaunch: function () {
        require('ts-node').register({
            project: 'e2e'
        });
        return new Promise(function (resolve) {
            reporter.beforeLaunch(resolve);
        });
    }, 
    onPrepare: function () {
        jasmine.getEnv().addReporter(new SpecReporter());
        jasmine.getEnv().addReporter(reporter);
        browser.ignoreSynchronization = true;  // disable waiting for Angular for non Angular applications
        browser.manage().timeouts().implicitlyWait(5000);
    },

  afterLaunch: function (exitCode) {
    return new Promise(function (resolve) {
      reporter.afterLaunch(resolve.bind(this, exitCode));
    });
  }
};
