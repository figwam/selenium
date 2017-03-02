import {Home} from '../pages/Home.po';
import {HomeSearchResult} from '../pages/HomeSearchResult.po';

describe('The Homepage', () => {
    let home = new Home();
    let homeSearchResult = new HomeSearchResult();

    beforeEach(() => {
    });

    it('BC01 should find iphone 7 as first result when searching for iphone 7', () => {
        home.open();
        home.doSearch('iphone 7');
        expect(homeSearchResult.productTitle.getText()).toMatch('Apple');
        expect(homeSearchResult.productTeaser.getText()).toMatch('iPhone 7');
    });
});
