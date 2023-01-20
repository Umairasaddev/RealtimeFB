package com.example.realtimefb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recyclerview_config {
    private Context mContext;
    private BooksAdapter mBooksAdapter;

    public void setConfig(RecyclerView recyclerView, BookListActivity bookListActivity,
                          List<Book> books, List<String> keys) {

        mContext = mContext;
        mBooksAdapter = new BooksAdapter(books, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mBooksAdapter);
    }

    class BookItemView extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mAuthor;
        private TextView mISBN;
        private TextView mCategory;

        private String key;//defining string variable for holding the key of the book record

        //constructor
        public BookItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.book_list_items, parent, false));

            mTitle = (TextView) itemView.findViewById(R.id.title_txt);
            mAuthor = (TextView) itemView.findViewById(R.id.author_txt);
            mISBN = (TextView) itemView.findViewById(R.id.isbn_txt);
            mCategory = (TextView) itemView.findViewById(R.id.category_txt);
        }

        public void bind(Book book, String key) {
            mTitle.setText(book.getTitle());
            mAuthor.setText(book.getAuthor());
            mCategory.setText(book.getCategory_name());
            mISBN.setText(book.getIsbn());

            this.key = key;

        }
    }
    class BooksAdapter extends RecyclerView.Adapter<BookItemView> {
        private List<Book> mBookList;
        private List<String> mKeys;


        public BooksAdapter(List<Book> mBookList, List<String> mKeys) {
            this.mBookList = mBookList;
            this.mKeys = mKeys;
        }


        @Override
        public BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BookItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BookItemView holder, int position) {

            holder.bind(mBookList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }
    }
}



//
//
//
//
//
//
//
//    class BookItemView extends RecyclerView.ViewHolder{
//         private TextView mTitle;
//         private TextView mAuthor;
//         private TextView mISBN;
//         private TextView mCategory;
//
//         private String key;//defining string variable for holding the key of the book record
//
//         //constructor
//         public BookItemView(ViewGroup parent){
//                super(LayoutInflater.from(mContext).
//                    inflate(R.layout.book_list_item,parent,false));
//
//                mTitle = (TextView) itemView.findViewById(R.id.title_txt);
//                mAuthor = (TextView) itemView.findViewById(R.id.author_txt);
//                mISBN = (TextView) itemView.findViewById(R.id.isbn_txt);
//                mCategory = (TextView) itemView.findViewById(R.id.category_txt);
//         }
//
//    }
//
//
//             public BooksAdapter() {
//                 super();
//             }
//
//             @NonNull
//
//
//
//
//
//}
