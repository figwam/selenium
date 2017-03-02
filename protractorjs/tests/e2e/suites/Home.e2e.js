'use strict';

var Home = require('../pages/Home.po.js')
var HomeSearchResult = require('../pages/HomeSearchResult.po.js');

var home;
var homeSearchResult;

beforeEach(function () {
  home = new Home();
  homeSearchResult = new HomeSearchResult();
  browser.ignoreSynchronization = true;  // disable waiting for Angular for non Angular applications
  browser.manage().timeouts().implicitlyWait(5000);
});

describe('swisscom homepage', function() {
  it('should find iphone 7 as first result when searching for iphone 7', function() {
    home.open();
    home.doSearch('iphone 7');
    expect(homeSearchResult.getProductTitle()).toEqual('Apple');
    expect(homeSearchResult.getProductTeaser()).toEqual('iPhone 7');
  });
});
