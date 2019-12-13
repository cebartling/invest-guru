module Types
    class StockType < Types::BaseObject
        description "A stock"
        field :id, ID, null: false
        field :symbol, String, null: false
        # fields should be queried in camel-case (this will be `truncatedPreview`)
        field :company_name, String, null: false
    end
end
