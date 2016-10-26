import { WeatherStationPage } from './app.po';

describe('weather-station App', function() {
  let page: WeatherStationPage;

  beforeEach(() => {
    page = new WeatherStationPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
