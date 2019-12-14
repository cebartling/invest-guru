module Types
  class StockType < Types::BaseObject
    description "A stock"
    field :id, ID, null: false
    field :symbol, String, null: false
    # fields should be queried in camel-case (this will be `truncatedPreview`)
    field :company_name, String, null: false
      #field :simple_moving_average_analytics,
      #      [Types::SimpleMovingAverageAnalyticType], null: false
  end
end
