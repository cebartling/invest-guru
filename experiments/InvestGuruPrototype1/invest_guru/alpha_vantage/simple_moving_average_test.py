import pytest

from invest_guru.alpha_vantage.simple_moving_average import simple_moving_average


@pytest.mark.integration
def test__simple_moving_average__success():
    result = simple_moving_average('MSFT', time_period=50)
    assert result is not None
